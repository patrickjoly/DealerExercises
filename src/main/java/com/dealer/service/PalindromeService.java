package com.dealer.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: patrick
 *
 * This service implements a palindrome validator. It uses a recursive method
 * to validate if a value is palindrome or not.
 */

@Service
public class PalindromeService implements Palindrome {

    private Logger log = this.log = Logger.getLogger(getClass());

    @Override
    public boolean validate(String value) {
        // a letter is not a palindrome against itself
        if (value.length() < 2) {
            log.debug("the value has zero or one char, in this case, it is not for sure:" + value);
            return false;
        }
        char[] charArray = value.toLowerCase().toCharArray();
        return stripAndValidate(charArray);
    }

    private boolean stripAndValidate(char[] value) {
        char[] charArray = this.stripNonAlphaNumeric(value);

        int charArrayLength = charArray.length;

        char firstLetter = charArray[0];
        char lastLetter = charArray[charArrayLength - 1];

        if (firstLetter != lastLetter) {
            return false;
        }
        char[] nextPattern = new char[charArray.length - 2];
        for (int i = 1; i < charArray.length - 1; i++) {
            nextPattern[i - 1] = charArray[i];
        }
        if (nextPattern.length < 2) {
            log.debug("the value is either the char in the middle or something like AA");
            return true;
        }
        // recursif call
        return this.stripAndValidate(nextPattern);
    }

    private static char[] stripNonAlphaNumeric(char[] charArray) {
        String regexAlphaNumeric = "^[a-zA-Z0-9]{1}$";
        char[] tempArray = new char[charArray.length];
        int lastIForTempArray = 0;
        for (int i = 0; i < charArray.length; i++) {
            String test = new String(Character.toString(charArray[i]));
            if (test.matches(regexAlphaNumeric)) {
                tempArray[lastIForTempArray] = charArray[i];
                lastIForTempArray++;
            }
        }
        char[] cleanCharArray = new char[lastIForTempArray];
        for (int i = 0; i < cleanCharArray.length; i++) {
            cleanCharArray[i] = tempArray[i];
        }
        return cleanCharArray;
    }
}
