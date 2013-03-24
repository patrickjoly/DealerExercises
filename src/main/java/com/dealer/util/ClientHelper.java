package com.dealer.util;

/**
 * Created with IntelliJ IDEA.
 * @Author: Patrick Joly
 *
 * Simple utility class that format the result properly.
 */
public class ClientHelper {

    public static void displayResult(String exercice, String result) {
        System.out.println("---------------------------------------------------");
        System.out.println("Excercice: --- " + exercice);
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------"+ System.getProperty("line.separator"));
        System.out.println(result);
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
    }
}
