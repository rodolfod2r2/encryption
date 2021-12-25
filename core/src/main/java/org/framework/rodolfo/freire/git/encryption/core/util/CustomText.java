package org.framework.rodolfo.freire.git.encryption.core.util;

public class CustomText {

    public static boolean isBlankOrNull(String text) {
        return (text == null || text.equals("") || text.trim().equals(""));
    }

    public static String fullLeftPositions(String text, char character, int totalSize) {
        return fullPositions(text, character, totalSize, Alignment.LEFT);
    }

    public static String fullRightPositions(String text, char character, int totalSize) {
        return fullPositions(text, character, totalSize, Alignment.RIGHT);
    }

    private static String fullPositions(String text, char character, int totalSize, Alignment tipo) {
        if (text == null || totalSize < 1) {
            return text;
        }
        String newText = text;
        while (newText.length() < totalSize) {
            if (tipo == Alignment.LEFT) {
                newText = character + newText;
                continue;
            }
            if (tipo == Alignment.RIGHT) {
                newText = newText + character;
            }
        }
        return newText;
    }


    private enum Alignment {
        RIGHT, LEFT
    }


}
