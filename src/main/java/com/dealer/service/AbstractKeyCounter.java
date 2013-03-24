package com.dealer.service;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author patrick
 *         <p/>
 *         This abstract class implements the basic behavior of the keyCounter.
 *         Subclasses have only to methods to provide (implement), getSource() and
 *         getDelimiter(). Once it is done, to obtain the result requires only
 *         a simple call to executeComputation.
 *         <p/>
 *         A default value of "," is used if no delimiter are provided by the sub class.
 */
public abstract class AbstractKeyCounter implements KeyCounter {

    protected static final String DEFAULT_DELIMITER = ",";
    protected String delimiter = DEFAULT_DELIMITER;
    private Logger log = this.log = Logger.getLogger(getClass());

    @Override
    public Map<String, Integer> executeComputation() {
        String source = getSource();
        log.debug("origine source is = " + source);
        Map<String, Integer> result = new HashMap<String, Integer>();
        // sanity check
        if (StringUtils.isEmpty(source)) throw new IllegalStateException();
        if (StringUtils.isEmpty(getDelimiter())) {
            log.debug("DEFAULT_DELIMITER as be applied");
            delimiter = DEFAULT_DELIMITER;
        }
        // computing
        Scanner scanner = new Scanner(source);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            log.debug("a scanned line = " + line);
            int indexOfDelimiter = line.indexOf(getDelimiter());
            if (indexOfDelimiter == -1) {
                log.error("No match with your delimiter has been found in source.");
                throw new RuntimeException("No match with your delimiter has been found in source.");
            }
            String[] aline = line.split(getDelimiter());
            replaceValue(result, aline);
        }
        return result;
    }

    private void replaceValue(Map<String, Integer> resultMap, String[] aline) {
        String key = aline[0];
        Integer newValue = Integer.valueOf(aline[1]);
        Integer oldValue = resultMap.get(key);
        if (oldValue != null) {
            resultMap.put(key, oldValue + newValue);
        } else {
            resultMap.put(key, newValue);
        }
    }

}
