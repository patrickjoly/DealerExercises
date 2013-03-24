package com.dealer.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Patrick Joly
 *
 * FileKeyCounterService read sources from a file and then, let the superclass
 * perform the calculation.
 *
 */
@Service
@Scope("prototype")
public class FileKeyCounterService extends AbstractKeyCounter {

    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String getSource() {
        try {
            if (filePath == null) throw new IllegalStateException("filePath cannot be null");
            return convertFileFromFileSystemToString(filePath);
        } catch (IOException ioe) {
            throw new RuntimeException("A problem occurred while trying to read the file.", ioe);
        }

    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    private String convertFileFromFileSystemToString(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream is = new FileInputStream(file);
        String inputStreamString = new Scanner(is, "UTF-8").useDelimiter("\\A").next();
        return inputStreamString;
    }



}
