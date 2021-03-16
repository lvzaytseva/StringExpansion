package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String compressedString = scanner.nextLine();

        System.out.println(StringExpansion.expandString(compressedString));

        scanner.close();
    }
}
