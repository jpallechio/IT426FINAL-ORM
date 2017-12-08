/**
 * Joseph Pallechio
 * IExporter.java
 * Interface for exporting data
 */
package io.exporting;

import model.PartsDatabase;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
public interface IExporter {

    /**
     * exports parts data to a file from the database
     *
     * @param partsDB the parts database the data will be exported from
     * @return success/failure
     */
    public boolean exportParts(PartsDatabase partsDB);
}
