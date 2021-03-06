package com.epam.jwd.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    private static final String EMPTY_STR = "";

    public static String read(String fileName) {
        try {
            logger.debug("Read file " + fileName);
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            logger.error("ReaderFile IOExeption" + e);
        }
        return EMPTY_STR;
    }
}
