/**
 * Joseph Pallechio
 * XMLExporter.java
 * Exports xml data about a carpart to a file
 */
package io.exporting;

import model.PartsDatabase;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public class XMLExporter implements IExporter {

    /**
     * exports parts data to a file from the database
     *
     * @param partsDB the parts database the data will be exported from
     * @return success/failure
     */
    public boolean exportParts(PartsDatabase partsDB) {
        //check if the parts is empty
        if (partsDB.isEmpty()) {
            return false;
        }

        try {
            File file = new File("src/main/resources/parts.xml");
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(partsDB, file);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return false;
    }
}
