/**
 * Joseph Pallechio
 * CarPart.java
 * Describes a CarPart object
 */
package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Joseph Pallechio
 * @version 1.0

 */
@Entity
@Table(name = "car_part", schema = "jpallech_hibernate")
@XmlRootElement
public class CarPart implements Serializable {
    private int id;
    private String manufacturer;
    private double listPrice;
    private String categories;

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
    public CarPart(int id, String manufacturer, double listPrice, String categories) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    @Id
    @Column(name = "id")
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "list_price")
    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Basic
    @Column(name = "categories")
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPart carPart = (CarPart) o;

        if (id != carPart.id) return false;
        if (Double.compare(carPart.listPrice, listPrice) != 0) return false;
        if (manufacturer != null ? !manufacturer.equals(carPart.manufacturer) : carPart.manufacturer != null)
            return false;
        return categories != null ? categories.equals(carPart.categories) : carPart.categories == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(listPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }
}
