package pt.ipp.isep.dei.esoft.project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;

/**
 * The type File ops.
 */
public class FileOps {

    /**
     * Read file file.
     *
     * @param filePath the file path
     * @return the file
     * @throws FileNotFoundException the file not found exception
     */
    public static File readFile(String filePath) throws FileNotFoundException{
        File file = null;
        try{
            file = new File(filePath);
        } catch (NullPointerException e){
            throw new IllegalArgumentException("Filepath is null");
        }

        if (!file.exists())
            throw new FileNotFoundException("File not found.");
        else if(!file.isFile() || !file.canRead())
            throw new IllegalArgumentException("The selected file is invalid.");
        else
            return file;
    }

    /**
     * Append to file boolean.
     *
     * @param filepath the filepath
     * @param content  the content
     * @return the boolean
     */
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

    /**
     * Create file boolean.
     *
     * @param filepath the filepath
     * @param content  the content
     * @return the boolean
     */
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

    /**
     * Delete file boolean.
     *
     * @param filepath the filepath
     * @return the boolean
     * @throws FileNotFoundException the file not found exception
     */
    public static boolean deleteFile(String filepath) throws FileNotFoundException {
        File file = readFile(filepath);
        return file.delete();
    }

    /**
     * Is file empty boolean.
     *
     * @param file the file
     * @return the boolean
     */
    public static boolean isFileEmpty(File file){
        return (file.length() == 0L);
    }


}
