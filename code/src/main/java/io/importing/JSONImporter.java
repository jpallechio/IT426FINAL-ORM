/**
 * Joseph Pallechio
 * JSONImporter.java
 * Imports json data about a carpart from file
 */

package io.importing;

import com.google.gson.Gson;
import model.CarPart;
import model.PartsDatabase;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class JSONImporter implements IImporter {

    /**
     * imports parts data from a file and saves it to the database
     * @param partsDB the parts database object that will be changed
     * @return success/failure
     */
    public boolean importParts(PartsDatabase partsDB) {

        //create Gson object
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("src/main/resources/parts.json");
            CarPart[] parts = gson.fromJson(reader, CarPart[].class);
            reader.close();

            //clear database before importing
            partsDB.clear();
            for (CarPart part : parts) {
                partsDB.addPart(part);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
