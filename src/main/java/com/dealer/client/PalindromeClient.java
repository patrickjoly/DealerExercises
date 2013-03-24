package com.dealer.client;

import com.dealer.service.Palindrome;
import com.dealer.util.ClientHelper;
import com.dealer.util.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Patrick Joly
 *
 * A simple client that plays with the service  PalindromeService.
 *
 * This client is called via a maven profile. See README.rm file. *
 *
 */
public class PalindromeClient {

    public static void main(String[] args) {
       if (args.length != 1) {
            System.out.println("Usage: You must enter un String that stands for the palindrome you want to evaluate");
        }
        // use a builder to work with interface only
        Palindrome palindrome = ServiceFactory.buildPalindromeService();
        boolean result = palindrome.validate(args[0]);
        String formattedResult = args[0] + (result ? " is " : " is not ") + "a palindrome" + System.getProperty("line.separator");
        ClientHelper.displayResult("Palindrome", formattedResult);
    }
}
