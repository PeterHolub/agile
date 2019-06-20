package com.peterholub.fileloader.impl;

import com.peterholub.fileloader.FileLoader;

import java.io.File;
import java.net.URL;

/**
 * Implementation of FileLoader interface
 */
public class FileLoaderImpl implements FileLoader {

    /**
     * @param fileName filename
     * @return File object
     */
    public File getFileFromResources(String fileName) {
        return new File(fileName).getAbsoluteFile();
        }

    }

