/**
 * Joseph Pallechio
 * JSONExporter.java
 * Exports JSON data about a carpart to a file
 */

package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;
import model.PartsDatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class JSONExporter implements IExporter {

    /**
     * exports parts data to a file from the database
     *
     * @param partsDB the parts database the data will be exported from
     * @return success/failure
     */
    public boolean exportParts(PartsDatabase partsDB) {
        //check if the parts is empty
        if(partsDB.isEmpty()){
            return false;
        }

        //parts collection
        Collection<CarPart> parts = partsDB.getParts();

        //create GSon object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //create cars array list
        CarPart[] partsArray = parts.toArray(new CarPart[0]);

        try {
            FileWriter writer = new FileWriter("src/main/resources/parts.json");
            gson.toJson(partsArray, writer);
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
