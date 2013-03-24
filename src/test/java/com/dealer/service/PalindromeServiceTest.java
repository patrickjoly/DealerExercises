package com.dealer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * @author: patrick
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class PalindromeServiceTest {

    @Autowired
    private PalindromeService palindromeService;

    @Test
    public void testNotAPalindrome() {
        boolean isPalindrome = palindromeService.validate("ItIsNotAPalindrome");
        assertFalse("This is not a palindrome", isPalindrome);
    }

    @Test
    public void testIsASimplePalindrome() {
        boolean isPalindrome = palindromeService.validate("Laval");
        assertTrue("It must be a palindrome", isPalindrome);
    }

    @Test
    public void testIsAComplexePalindrome() {
        boolean isPalindrome = palindromeService.validate("Ah, Satan sees Natasha");
        assertTrue("It must be a palindrome even " +
                "if there is non-alphanumeric characters", isPalindrome);
    }
}
