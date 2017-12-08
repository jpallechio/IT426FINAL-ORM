/**
 * Joseph Pallechio
 * JavaImporter.java
 * Imports xml data about a carpart from file
 */

package io.importing;

import model.CarPart;
import model.PartsDatabase;

import java.io.*;
import java.util.Collection;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class JavaImporter implements IImporter {

    /**
     * imports parts data from a file and saves it to the database
     *
     * @param partsDB the parts database object that will be changed
     * @return success/failure
     */
    public boolean importParts(PartsDatabase partsDB) {

        try {
            FileInputStream fileInputStream = new FileInputStream(
                    new File("src/main/resources/parts.dat"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Collection<CarPart> parts = (Collection<CarPart>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            //clear and then add new elements
            partsDB.clear();
            for (CarPart part : parts) {
                partsDB.addPart(part);
            }

            //import was succesful
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
