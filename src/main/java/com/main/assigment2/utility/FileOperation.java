package com.main.assigment2.utility;


import java.io.*;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class FileOperation {
    //Populating list of files
    private List<String> listOfFile;

    private static final Logger log=Logger.getLogger("FileOperation.class");

    public FileOperation(){
        listOfFile=new LinkedList<String>();
    }

    //Method to list all the files in Source directory
    public void listAllFiles(File folder){
        log.info("listAllFiles: Listing out all the files");
        File[] fileNames = folder.listFiles();
        for(File file : fileNames){
            // if directory call the same method again
            if(file.isDirectory()){
                listAllFiles(file);
            }else{
                log.info("listAllFiles: Adding files to the filesList");
                listOfFile.add(file.getName());
            }
        }
    }

    public void iterateFilesAndCopyToDestination(String modelDirectory) throws IOException {
        log.info("iterateFilesAndCopyToDestination: Searching from model directory and copying ");
        for(String filePath:listOfFile){
            findFilesFromModelAndCopyToDest(new File(filePath),new File(modelDirectory));
        }
    }

//    //Reading file content from given folder
//    public void readContent(File file) throws IOException{
//       log.info("read file " + file.getCanonicalPath() );
//        try(BufferedReader br  = new BufferedReader(new FileReader(file))){
//            String strLine;
//            // Read lines from the file, returns null when end of stream
//            // is reached
//            while((strLine = br.readLine()) != null){
//                System.out.println("Line is - " + strLine);
//            }
//        }
//    }

    //Search sourcefiles from model directory and copy to dest directory
    private void findFilesFromModelAndCopyToDest(final File fileToSearch,File modelDirectory) throws IOException {
        log.info("findFilesFromModelAndCopyToDest: Iterating to model directory "+modelDirectory.getCanonicalPath());
        File[] fileNames = modelDirectory.listFiles();
        for(File file : fileNames){
            // if directory call the same method again
            if(file.isDirectory()){
                findFilesFromModelAndCopyToDest(fileToSearch,file);
            }else if(file.getName().equals(fileToSearch.getName())){

                String destPath=changeAndGetTheDestPath(file.getAbsolutePath());
                log.info("findFilesFromModelAndCopyToDest: copy file "+file.getName()+" dest directory "+destPath);
                copyFile(file,new File(destPath));
            }
        }
    }

    //Form the destinationPath
    private String changeAndGetTheDestPath(String modelPath){
        String destPath=null;
        String temp[]=null;

        temp=modelPath.split("model");
        destPath=temp[0]+"dest"+temp[1];

        temp=destPath.split("src");
        destPath=temp[0]+"src/main/java"+temp[1];
        log.info("changeAndGetTheDestPath: destPath ="+destPath);

        return destPath;
    }

//    public void copyFileFromSrcToDestPath(File sourceLocation,File targetLocation) throws IOException{
//        if (sourceLocation.isDirectory()) {
//            if (!targetLocation.exists()) {
//                targetLocation.mkdir();
//            }
//
//            String[] children = sourceLocation.list();
//            for (int i=0; i<children.length; i++) {
//                copyFileFromSrcToDestPath(new File(sourceLocation, children[i]),
//                        new File(targetLocation, children[i]));
//            }
//        } else {
//
//            InputStream in = new FileInputStream(sourceLocation);
//            OutputStream out = new FileOutputStream(targetLocation);
//
//            // Copy the bits from instream to outstream
//            byte[] buf = new byte[1024];
//            int len;
//            while ((len = in.read(buf)) > 0) {
//                out.write(buf, 0, len);
//            }
//            in.close();
//            out.close();
//        }
//    }
//
//    public void getPathForFileName(String name,File  file){
//        File[] list = file.listFiles();
//        if(list!=null)
//            for (File fil : list)
//            {
//                if (fil.isDirectory())
//                {
//                    getPathForFileName(name,fil);
//                }
//                else if (name.equalsIgnoreCase(fil.getName()))
//                {
//                    System.out.println(fil.getParentFile());
//                }
//            }
//    }

    //Copy file from src to destination
    private static void copyFile(File sourceFile, File destFile)
            throws IOException {
        if (!sourceFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;

        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();

        log.info("copyFile: coppying file from src "+sourceFile.getName()+" destination= "+destFile.getCanonicalPath());
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }

    }

//    public void copyFileFromSrcToDest(String srcPath,String destPath){
//        File trgDir = new File(destPath);
//        File srcDir = new File(srcPath);
//
//        FileUtils.copyDirectory(srcDir, trgDir);
//    }

//    public void readContent(Path filePath) throws IOException{
//        System.out.println("read file " + filePath);
//        List<String> fileList = Files.readAllLines(filePath);
//        System.out.println("" + fileList);
//    }
}
