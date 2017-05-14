package com.company;

class Sentence {
    private Word[] words = null;
    private Delimiter delimiter = null;

    Sentence(StringBuffer sentence) {
        if (sentence.length() != 0) {
            Clean(sentence);
            if (!isDelimiter(sentence.charAt(sentence.length() - 1))) {
                sentence.append('.');
            }
            else delimiter = new Delimiter(sentence.charAt(sentence.length() - 1));
            words = new Word[countWords(sentence)];
            StringBuffer word;
            int j = 0;

            do {
                int start = -1, end = -1;
                for (int i = 0; i < sentence.length(); i++) {
                    if (!isDelimiter(sentence.charAt(i)) && (start == -1)) {
                        start = i;
                        continue;
                    }
                    if (isDelimiter(sentence.charAt(i)) && (i - start > 0) && (start != -1)) {
                        end = i;
                        break;
                    }
                }
                if (start == -1 || end == -1) {
//                    word = new StringBuffer("");
//                    sentence = new StringBuffer(sentence.substring(0, sentence.length()));
                    break;
                } else {

                    word = new StringBuffer(sentence.substring(start, end));
                    words[j] = new Word(word);
                    sentence = new StringBuffer(sentence.substring(end, sentence.length()));
                }
                j++;
            }
            while (j < words.length);
        }
    }


    void replaceFirstAndLastWords() {
        if (words != null) {
            Word temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;

        }
    }

    void printSentence() {
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i].getCharAt(0)!=',') System.out.print(' ');
            words[i].printWord();
        }
        if (delimiter != null) System.out.print(delimiter.getValue()+" ");
    }

    private int countWords(StringBuffer string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!isDelimiter(string.charAt(i)) && i + 1 < string.length() && isDelimiter(string.charAt(i + 1)))
                count++;
        }
        return count;
    }


    private void Clean(StringBuffer string) {
        if (string != null) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) ==','){
                    string.insert(i,' ');
                    i++;
                }
                if (string.charAt(i) == '\t') {
                    string.setCharAt(i, ' ');
                }
                if (string.charAt(i) == ' ' && i + 1 < string.length() && string.charAt(i + 1) == ' ') {
                    string.deleteCharAt(i);
                    i--;
                }
            }
            if (string.charAt(string.length() - 1) == ' ') string.deleteCharAt(string.length() - 1);
            if (string.charAt(string.length() - 2) == ' ') string.deleteCharAt(string.length() - 2);
        }
    }

    private boolean isDelimiter(char c) {
        Word delimiters = new Word(new StringBuffer(" .!?;\t\n\r"));
        for (int i = 0; i < delimiters.length(); i++) {
            if (c == delimiters.getCharAt(i)) return true;
        }
        return false;
    }

}