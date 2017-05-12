package com.company;

/**
 * Created by Evgeniia Zubrich on 28.04.2017.
 */
public class StringTransformer {
    private StringBuffer myString = null;

    private StringBuffer lastWord = null;
    private StringBuffer firstWord = null;
    private StringBuffer theRestOfLine = null;

    StringTransformer(String string) {
        myString = new StringBuffer(string);
    }


    public StringBuffer ReplaceFirstAndLast() {
        firstWord = new StringBuffer(findFirstWord(myString));
        if (theRestOfLine != null)
            lastWord = new StringBuffer(findLastWord(theRestOfLine));
        return lastWord.append(theRestOfLine).append(firstWord);

    }

    private String findFirstWord(StringBuffer string) {
        if (string != null) {
            StringBuffer delimiters = new StringBuffer(" ,.?!:\'\"\n\t\r");
            int startPos = -1, endPos = -1;
            for (int i = 0; i < string.length(); i++) {
                if (!isDelimiter(string.charAt(i), delimiters) && (startPos == -1)) {
                    startPos = i;
                    continue;
                }
                if (isDelimiter(string.charAt(i), delimiters) && (i - startPos > 0) && (startPos != -1)) {
                    endPos = i;
                    break;
                }
            }
            if (startPos == -1 || endPos == -1) {
                theRestOfLine = new StringBuffer(string.substring(0, string.length()));
                return "";
            }
            theRestOfLine = new StringBuffer(string.substring(endPos, string.length()));
            return string.substring(startPos, endPos);
        }
        return null;
    }

    private String findLastWord(StringBuffer string) {
        if (string != null) {
            StringBuffer delimiters = new StringBuffer(" ,.?!:\'\"\n\t\r");
            int startPos = -1, endPos = -1;
            string.append('.');
            for (int i = string.length() - 1; i >= 0; i--) {
                if (isDelimiter(string.charAt(i), delimiters) && (startPos == -1)) {
                    endPos = i;
                    continue;
                }
                if (!isDelimiter(string.charAt(i), delimiters) && (endPos - i > 0)) {
                    startPos = i;
                    if ((i != 0 && isDelimiter(string.charAt(i - 1), delimiters)) || i == 0)
                        break;
                }
            }
            string.deleteCharAt(string.length() - 1);
            if (startPos == -1 || endPos == -1) {
                theRestOfLine = new StringBuffer(string.substring(0, string.length()));
                return "";
            }
            theRestOfLine = new StringBuffer(string.substring(0, startPos));
            return string.substring(startPos, endPos);
        }
        return null;
    }

    private boolean isDelimiter(char c, StringBuffer delimiters) {
        for (int i = 0; i < delimiters.length(); i++) {
            if (c == delimiters.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}
