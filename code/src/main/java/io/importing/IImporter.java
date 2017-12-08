/**
 * Joseph Pallechio
 * IImporter.java
 * Interface for importing
 */
package io.importing;

import model.PartsDatabase;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public interface IImporter
{
    /**
     * imports parts data from a file and saves it to the database
     * @param partsDB the parts database object that will be changed
     * @return success/failure
     */
    public boolean importParts(PartsDatabase partsDB);
}
