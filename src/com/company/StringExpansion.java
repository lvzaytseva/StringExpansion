package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpansion {

    private static final String regEx = "\\d\\[[a-zA-Z]+?]";
    private static Pattern pattern;
    private static Matcher matcher;
    private static String expandedString;

    public static String expandString(String compressedString) {
        expandedString = compressedString;
        setMatcher();
        while (matcher.find()) {
            expandSubstring();
            resetMatcher();
        }
        if (isValid()) {
            return expandedString;
        } else {
            return "Невалидная строка";
        }
    }

    private static boolean isValid() {
        return expandedString.matches("[a-zA-Z]*");
    }

    private static void setMatcher() {
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(expandedString);
    }
    private static void resetMatcher() {
        matcher.reset();
        matcher = pattern.matcher(expandedString);
    }

    //распоковка подстроки
    private static void expandSubstring() {
        String match = expandedString.substring(matcher.start(), matcher.end());
        int count = Character.getNumericValue(match.charAt(0)); //количество повторений
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < count; i++) {
            replacement.append(match, 2, match.length() - 1); //содержимое между скобками [...]
        }
        expandedString = expandedString.replace(match, replacement.toString());
    }
}
