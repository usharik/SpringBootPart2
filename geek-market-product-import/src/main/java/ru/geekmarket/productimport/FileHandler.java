package ru.geekmarket.productimport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileHandler {

    private static Logger logger = LoggerFactory.getLogger(FileHandler.class);

    public File handleFile(File input) {
       logger.info("Copying file: {}", input.getAbsolutePath());
        return input;
    }
}