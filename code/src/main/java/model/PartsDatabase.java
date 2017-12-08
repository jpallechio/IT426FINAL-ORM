/**
 * Joseph Pallechio
 * PartsDatabase.java
 * Represents Database object for parts
 */
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Joseph Pallechio
 * @version 1.0
 */
@XmlRootElement
public class PartsDatabase
{
    private Collection<CarPart> parts;

    /**
     * constructor the instantiates inner arraylist
     */
    public PartsDatabase()
    {
        parts = new ArrayList<CarPart>();
    }

    /**
     * adds part to database
     * @param part part to be added
     */
    public void addPart(CarPart part)
    {
        parts.add(part);
    }

    /**
     * returns collections of parts
     * @return returns collections of parts
     */
    @XmlElement
    public Collection<CarPart> getParts()
    {
        return parts;
    }

    /**
     * clears parts
     */
    public void clear()
    {
        parts.clear();
    }

    /**
     * returns true/false if the database is empty/filled
     * @return returns true/false if the database is empty/filled
     */
    public boolean isEmpty(){
        return this.parts.isEmpty();
    }
}
