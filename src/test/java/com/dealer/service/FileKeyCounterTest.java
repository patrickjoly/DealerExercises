package com.dealer.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * @author: patrick
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class FileKeyCounterTest {

    private static String FILE_PATH = "src/test/resources/keycountdata.txt";

    @Autowired
    FileKeyCounterService keyCounter;

    @Test(expected = IllegalStateException.class)
    public void testExecutionWithoutFilePath() throws Exception {
        keyCounter.executeComputation();
    }

    @Test(expected = RuntimeException.class)
    public void testExecutionWithAWrongFilePath() throws Exception {
        keyCounter.setFilePath("wrongfilePath");
        keyCounter.executeComputation();
    }

    @Test(expected = RuntimeException.class)
    public void testWithABadDelimiter() throws Exception {
        keyCounter.setFilePath(FILE_PATH);
        keyCounter.setDelimiter(";");
        keyCounter.executeComputation();
    }

    @Test
    public void testComputeWithDefaultDelimiter() throws Exception {
        keyCounter.setFilePath(FILE_PATH);

        Map<String, Integer> result = keyCounter.executeComputation();

        if (result == null) {
            fail("result should not be null");
        }
        assertTrue(result.size() == 2);
        assertTrue(result.get("John").equals(3));
        assertTrue(result.get("Jane").equals(8));
    }

    @Test
    public void testComputeWithProvidedDelimiter() throws Exception {
        keyCounter.setFilePath(FILE_PATH);
        keyCounter.setDelimiter(",");
        Map<String, Integer> result = keyCounter.executeComputation();
        if (result == null) {
            fail("result should not be null");
        }
        assertTrue(result.size() == 2);
        assertTrue(result.get("John").equals(3));
        assertTrue(result.get("Jane").equals(8));
    }


}
