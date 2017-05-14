package com.company;

class Text {
    private Sentence[] sentences = null;

    Text(StringBuffer text) {
        if (text.length() != 0) {
            if (!isDelimiter(text.charAt(text.length() - 1))) {
                text.append('.');
            }
            sentences = new Sentence[countSentences(text)];
            StringBuffer sentence;
            int j = 0;
            do {
                int start = -1, end = -1;
                for (int i = 0; i < text.length(); i++) {
                    if (!isDelimiter(text.charAt(i)) && (start == -1)) {
                        start = i;
                        continue;
                    }
                    if (isDelimiter(text.charAt(i)) && (i - start > 0) && (start != -1)) {
                        end = i;
                        if (i+1 <= text.length()) end++;
                        break;
                    }
                }
                if (start == -1 || end == -1) {
                    break;
                } else {
                    sentence = new StringBuffer(text.substring(start, end));
                    sentences[j] = new Sentence(sentence);
                    text = new StringBuffer(text.substring(end, text.length()));
                }
                j++;
            }  while (j < sentences.length);
        } else System.out.println("Line is empty");

    }

    private int countSentences(StringBuffer string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!isDelimiter(string.charAt(i)) && i + 1 < string.length() && isDelimiter(string.charAt(i + 1)))
                count++;
        }
        return count;
    }


    private boolean isDelimiter(char c) {
        Word delimiters = new Word(new StringBuffer(".!?;\t\n\r"));
        for (int i = 0; i < delimiters.length(); i++) {
            if (c == delimiters.getCharAt(i)) return true;
        }
        return false;
    }

    void replaceFirstAndLastWords(){
        if(sentences!=null){
            for (Sentence sentence : sentences) {
                sentence.replaceFirstAndLastWords();
            }
        }
    }


    void printText(){
        if(sentences!=null){
            for (Sentence sentence : sentences) {
                sentence.printSentence();
            }
        }
    }
}
