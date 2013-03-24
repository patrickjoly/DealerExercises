package com.dealer.util;

import com.dealer.service.FileKeyCounterService;
import com.dealer.service.KeyCounter;
import com.dealer.service.Palindrome;
import com.dealer.service.PalindromeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * @author: Patrick Joly
 *
 * Utility class that simplify the way we expose our services for a client.
 *
 */
public class  ServiceFactory {

    public static Object getBean(Class clazz) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        return context.getBean(clazz);
    }

    public static Palindrome buildPalindromeService() {
        PalindromeService palindromeService = (PalindromeService) getBean(PalindromeService.class);
        return palindromeService;
    }

    public static KeyCounter buildFileKeyCounterService(String filePath, String delimiter) {
        FileKeyCounterService fileKeyCounter = (FileKeyCounterService) getBean(FileKeyCounterService.class);
        fileKeyCounter.setFilePath(filePath);
        fileKeyCounter.setDelimiter(delimiter);
        return fileKeyCounter;
    }

}
