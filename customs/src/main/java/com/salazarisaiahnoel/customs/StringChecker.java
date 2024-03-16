package com.salazarisaiahnoel.customs;

public class StringChecker {
    public static boolean hasSymbols(String input){
        String symbols = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
        for (int a = 0; a < input.length(); a++){
            for (int b = 0; b < symbols.length(); b++){
                if (input.charAt(a) == symbols.charAt(b)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNumbers(String input){
        String numbers = "1234567890";
        for (int a = 0; a < input.length(); a++){
            for (int b = 0; b < numbers.length(); b++){
                if (input.charAt(a) == numbers.charAt(b)){
                    return true;
                }
            }
        }
        return false;
    }
}
