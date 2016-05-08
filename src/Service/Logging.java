package Service;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;

/**
 * Created by a_pan on 08.05.2016.
 */
public class Logging {
    public static void addLog(String logData) {
        File logging = null;
        try {
            logging = new File("Logging.txt");
            if (!logging.exists()) {
                logging.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        writeLogInFile(logData, logging);
    }

    private static void writeLogInFile(String line, File logging) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(logging, "rw");
            String s;
            while ((s = raf.readLine()) != null) {
                raf.seek(raf.getFilePointer());
            }
            raf.writeBytes(LocalDateTime.now() + "  Method called - " + line + "\n");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException i) {
            }
        }
    }

}
