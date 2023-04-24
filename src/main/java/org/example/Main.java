package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startValidate();
    }


    public static Scanner scanner = new Scanner(System.in);
    public static String[] forbiddenPasswordList = {"12345678", "Passwort123!"};
    public static char[] specialCharacter = {'!', '"', '§', '$', '%', '&', '/', '(', ')', '=', '?', '`', '²', '³', '{', '[', ']', '}', 'ß', '´', '+', '*', '~', '#', '-', '_', ',', ';', '.', ':', 'µ', '<', '>', '|', '^', '°', '@', '€'};

    public static boolean checkUpperCase(String password) {
        return !password.equals(password.toLowerCase());
    }

    public static boolean checkLowerCase(String password) {
        return !password.equals(password.toUpperCase());
    }

    public static boolean checkSpecialCharacter(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            for (int x = 0; x < specialCharacter.length; x++) {
                if (chars[i] == specialCharacter[x]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkNums(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(chars[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLongerThan7(String Password) {
        if (Password.length() > 7) {
            return true;
        } else return false;
    }

    public static boolean startValidate() {
        if (isAllowed(reader())) {
            System.out.println("Das Passwort ist valide");
            return true;
        } else {
            System.out.println("Das Passwort entspricht nicht unseren Sicherheitsbestimmungen, bitte beachte:" +
                    "\nmindestens 8 Zeichen lang" +
                    "\nmin ein Großbuchstabe" +
                    "\nmin ein Kleinbuchstabe" +
                    "\nmin eine Zahl" +
                    "\nmin ein Sonderzeichen.");
            return startValidate();
        }
    }

    // Eingabe des Users einlesen (scanner)
    public static String reader() {
        System.out.println("Bitte geben Sie das zu validierende Passwort ein: ");
        return scanner.nextLine();
    }

    // Vergleich mit Datenbank der nicht erlaubten Passwörter und dem Safety Checker
    public static boolean isAllowed(String Password) {
        for (int i = 0; i < forbiddenPasswordList.length; i++) {
            if (forbiddenPasswordList[i].equals(Password)) {
                System.out.println("Das Passwort ist nicht gültig!");
                return false;
            }
        }
        return safetyCheck(Password);
    }

    // Gegenchecken ob Sicherheitsstandards erfüllt sind (ein Großbuchstabe, ein Kleinbuchstabe, eine Zahl und ein Sonderzeichen. Min 8 Zeichen lang)
    public static boolean safetyCheck(String Password) {
        if (checkUpperCase(Password)
                && checkLowerCase(Password)
                && checkSpecialCharacter(Password)
                && checkNums(Password)
                && isLongerThan7(Password)) {
            return true;
        } else return false;
    }



}