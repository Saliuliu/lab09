package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    File file;

    public Controller(){
        setFile(System.getProperty("user.home")
                + File.separator
                + "output.txt"
            );
    }

    public Controller(String s){
        setFile(s);
    }

    public void setFile(String path){
        file = new File(path);
    }

    public String getCurrentFile(){
        if (file == null) {
            throw new IllegalStateException("There is no such file opened");
        }
        return file.getPath();
    }

    public void saveOnFile(String s) throws IOException {
        if (file == null) {
            throw new IllegalStateException("There is no such file opened");
        }
        file.createNewFile();
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
