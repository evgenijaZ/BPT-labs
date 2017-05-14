package com.company;

public class Word {
    private Letter[] letters = null;

    Word(StringBuffer word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    public void printWord() {
        if (letters != null) {
            for (Letter letter : letters) {
                System.out.print(letter.getValue());
            }
        }
    }
    int length(){
        return this.letters.length;
    }

    char getCharAt(int position){
        return this.letters[position].getValue();
    }
    public Letter getLetterAt(int position){
        return this.letters[position];
    }
}
