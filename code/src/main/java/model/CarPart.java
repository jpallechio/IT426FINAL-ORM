/**
 * Joseph Pallechio
 * CarPart.java
 * Describes a CarPart object
 */
package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Joseph Pallechio
 * @version 1.0

 */
@XmlRootElement

public class CarPart implements Serializable {
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;


    public CarPart() {
        //do nothing - leave this method here...
    }

    /**
     * constructor for carpart object
     * @param id id of part
     * @param manufacturer manufacturer's name
     * @param listPrice listing price
     * @param categories category
     */
    public CarPart(String id, String manufacturer, double listPrice, String[] categories) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getListPrice() {
        return listPrice;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }


}
