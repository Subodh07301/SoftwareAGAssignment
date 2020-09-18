package com.main.assigment2;

import com.main.assigment2.utility.FileOperation;
import java.io.File;
import java.io.IOException;

/**
 * Download this collections of java source files
 * http://dl.dropbox.com/u/23064251/merge.tar.gz
 * There are three directories in that tarball (“source”, “dest” and “model”)
 * The “source” directory contains a small number of java files. The task is
 * to copy/move them from the “source” directory into the appropriate subdirectory of the “dest”
 * based on information found in “model” directory
 *
 *
 * As an example consider this file from the “source” folder:
 * source/com/tc/text/Banner.java
 * Searching the “model” directory there exists a Banner.javaat this path:
 * model/common-api/src/com/tc/text/Banner.java
 *
 *
 * Therefore the file should be moved from “source” to “dest” with the path discovered in “model”
 * dest/common-api/src/main/java/com/tc/text/Banner.java
 *
 * There doesn’t need to be any particular interface for this program
 * (ie. paths can be hard coded so as to not require any command line arguments).
 * There is no specification for any output either, the task of moving the files to
 * the appropriate location is only requirement. Any error/exceptional conditions (if any)
 * can simply be printed in any format desired to System.err
 */

public class FileCopyFromOneFolderToAnother {
    private final FileOperation fileOperation;
    public FileCopyFromOneFolderToAnother(){
        fileOperation=new FileOperation();
    }

    //Get all the list of files and search from model
    public void copyAlltheFilesFromSrcToDest() throws IOException {
        fileOperation.listAllFiles(new File(ConstantsDeclaration.SRC_PATH));
        fileOperation.iterateFilesAndCopyToDestination(ConstantsDeclaration.MODEL_PATH);
    }
}
