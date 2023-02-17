import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

import java.util.Random;

public class PasswortGenerator
{
    public static void main(String[] args)
    {
        printMenu();
        while (true) {
            generatePasswort();
        }
    }

    public static void printMenu()
    {
        System.out.println("--------------------");
        System.out.println("1. Großbuchstaben und Ziffern");
        System.out.println("2. Kleinbuchstaben und Sonderzeichen");
        System.out.println("3. Nur Ziffern");
        System.out.println("4. Alle Buchstaben und Ziffern");
        System.out.println("5. Alle Buchstaben, Ziffern und Sonderzeichen");
        System.out.println("--------------------");
        System.out.println("1-3 Stellen: " + "\u001B[31m" + "sehr schlecht" + "\u001B[0m");
        System.out.println("4-6 Stellen: " + "\u001B[33m" + "schlecht" + "\u001B[0m");
        System.out.println("7-8 Stellen: " + "\u001B[32m" + "gut" + "\u001B[0m");
        System.out.println("9-10 Stellen: " + "\u001B[34m" + "sehr gut" + "\u001B[0m");
        System.out.println("11-... Stellen: " + "\u001B[35m" + "stark" + "\u001B[0m");
        System.out.println("--------------------" + "\n");
    }

    public static void generatePasswort()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Damit sie ein " + "\u001B[34m" + "Passwort" + "\u001B[0m" + " erstellen können,");
        System.out.print("wählen sie bitte ihre gewünschte Zahl >> ");
        String option = scanner.nextLine();

        System.out.print("Wählen sie jetzt bitte noch die Anzahl der Stellen >> ");
        String numberChoice = scanner.nextLine();

        //Dictionary
        Map<String, String> characters = new HashMap<>();
        characters.put("1", "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        characters.put("2", "abcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        characters.put("3", "0123456789");
        characters.put("4", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        characters.put("5", "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

        StringBuilder passwort = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < Integer.parseInt(numberChoice); i++)
        {
            switch (option) {
                case "1" -> {
                    String symbol = String.valueOf(characters.get("1").charAt(rand.nextInt(characters.get("1").length())));
                    passwort.append(symbol);
                }
                case "2" -> {
                    String symbol = String.valueOf(characters.get("2").charAt(rand.nextInt(characters.get("2").length())));
                    passwort.append(symbol);
                }
                case "3" -> {
                    String symbol = String.valueOf(characters.get("3").charAt(rand.nextInt(characters.get("3").length())));
                    passwort.append(symbol);
                }
                case "4" -> {
                    String symbol = String.valueOf(characters.get("4").charAt(rand.nextInt(characters.get("4").length())));
                    passwort.append(symbol);
                }
                case "5" -> {
                    String symbol = String.valueOf(characters.get("5").charAt(rand.nextInt(characters.get("5").length())));
                    passwort.append(symbol);
                }
                default -> {
                    System.out.println("--------------------" + "\n");
                    System.out.println("Das war leider falsch");
                    System.out.println("Wählen sie bitte nur eine Zahl zwischen 1 und 5" + "\n");
                    System.out.println("--------------------");
                }
            }
        }

        System.out.println("\n" + "Ihr " + "\u001B[34m" + "Passwort" +  "\u001B[0m" + " lautet: " + "\u001B[31m" + passwort + "\u001B[0m");

        int nC = Integer.parseInt(numberChoice);

        if (nC < 4) {
            System.out.println(numberChoice + " Stellen: " + "\u001B[31m" + "sehr schlecht" + "\u001B[0m" + "\n\n");
        } else if (nC < 7) {
            System.out.println(numberChoice + " Stellen: " + "\u001B[33m" + "schlecht" + "\u001B[0m" + "\n\n");
        } else if (nC < 9) {
            System.out.println(numberChoice + " Stellen: " + "\u001B[32m" + "gut" + "\u001B[0m" + "\n\n");
        } else if (nC < 11) {
            System.out.println(numberChoice + " Stellen: " + "\u001B[34m" + "sehr gut" + "\u001B[0m" + "\n\n");
        } else {
            System.out.println(numberChoice + " Stellen: " + "\u001B[35m" + "stark" + "\u001B[0m" + "\n\n");
        }
    }
}