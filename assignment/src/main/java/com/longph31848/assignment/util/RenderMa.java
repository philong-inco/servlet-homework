package com.longph31848.assignment.util;

import java.util.Random;

public class RenderMa {

    public static String renderMa(String str, int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        String prefix = str;
        if (str.length() > 2 ) {
            prefix = str.substring(0, 2);
        }
        Random random = new Random();
        for (int i = 0; i < length - prefix.length(); i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }
        return prefix + sb.toString();
    }
}
