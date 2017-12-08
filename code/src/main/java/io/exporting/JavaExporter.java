/**
 * Joseph Pallechio
 * JavaExporter.java
 * Exports java data about a carpart to a file
 */
package io.exporting;

import model.PartsDatabase;
import java.io.*;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class JavaExporter implements IExporter {

    /**
     * exports parts data to a file from the database
     *
     * @param partsDB the parts database the data will be exported from
     * @return success/failure
     */
    public boolean exportParts(PartsDatabase partsDB) {
        //check if the parts is empty
        if (partsDB.isEmpty()) {
            System.out.println("parts is empty");
            return false;
        }

        try {
            //get the output stream
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("src/main/resources/parts.dat"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(partsDB.getParts());

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            return false;
        }
        //export was successful
        return true;
    }
}
