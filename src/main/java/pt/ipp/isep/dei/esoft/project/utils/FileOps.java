package pt.ipp.isep.dei.esoft.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;

public class FileOps {

    public static File readFile(String filePath) throws FileNotFoundException{
        File file = new File(filePath);

        if (!file.exists())
            throw new FileNotFoundException("File not found.");
        else if(!file.isFile() || !file.canRead())
            throw new IllegalArgumentException("The selected file is invalid.");
        else
            return file;
    }

    public static boolean appendToFile(String filepath, String content){
        File file = new File(filepath);
        try {
            Writer writer = new FileWriter(file, true);
            try{
                writer.write(content);
            } catch (Exception e){
                writer.close();
                return false;
            } finally {
                writer.close();
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean createFile(String filepath, String content) {
        File file = new File(filepath);
        try {
            Writer writer = new FileWriter(file,false);
            try {
                writer.write(content);
            } finally {
                writer.close();
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean deleteFile(String filepath) throws FileNotFoundException {
        File file = readFile(filepath);
        return file.delete();
    }

    public static boolean isFileEmpty(File file){
        return (file.length() == 0L);
    }


}
