package com.dealer.service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Patrick Joly
 *
 * This interface defines the behavior of a keycounter object.
 *
 */
public interface KeyCounter {

    Map<String, Integer> executeComputation();

    String getSource();

    String getDelimiter();
}
