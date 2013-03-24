package com.dealer.client;

import com.dealer.service.KeyCounter;
import com.dealer.util.ClientHelper;
import com.dealer.util.ServiceFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Patrick Joly
 *         <p/>
 *         A simple client that plays with the service  FileKeyCounterService.
 *         <p/>
 *         This client is called via a maven profile. See README.rm file.
 */
public class KeyCounterClient {

    public static void main(String[] args) {
        KeyCounter keyCounter = null;

        if (args.length == 1) {
            System.out.println("arg1 = " + args[0]);
            keyCounter = ServiceFactory.buildFileKeyCounterService(args[0], null);
        }
        if (args.length == 2) {
            System.out.println("arg1 = " + args[0]);
            System.out.println("arg2 = " + args[1]);
            keyCounter = ServiceFactory.buildFileKeyCounterService(args[0], args[1]);
        }

        Map<String, Integer> result = keyCounter.executeComputation();
        StringBuilder sb = new StringBuilder();
        for (String s : result.keySet()) {
            sb.append("The total for " + s + " is " + result.get(s) + System.getProperty("line.separator"));
        }
        ClientHelper.displayResult("KeyCounter", sb.toString());

    }
}
