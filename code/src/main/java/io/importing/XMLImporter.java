/**
 * Joseph Pallechio
 * XMLImporter.java
 * Imports xml data about a carpart from file
 */
package io.importing;

import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class XMLImporter implements IImporter {

    /**
     * imports parts data from a file and saves it to the database
     * @param partsDB the parts database object that will be changed
     * @return success/failure
     */
    public boolean importParts(PartsDatabase partsDB) {
        try {
            File file = new File("src/main/resources/parts.xml");

            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            PartsDatabase partsDatabase = (PartsDatabase) unmarshaller.unmarshal(file);

            //clear database and then add new elements
            partsDB.clear();
            for (CarPart part : partsDatabase.getParts()) {
                partsDB.addPart(part);
            }

            return true;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return false;
    }
}
