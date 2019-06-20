package com.peterholub.fileloader;

import java.io.File;

/**
 * Defines method for getting files from resources folder
 */
public interface FileLoader {
    /**
     * @param fileName filename
     * @return File object
     */
 File getFileFromResources(String fileName);
}
