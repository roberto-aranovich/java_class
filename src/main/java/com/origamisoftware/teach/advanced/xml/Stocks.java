
package com.origamisoftware.teach.advanced.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}stock" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
"stock"
})
@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject{

    @XmlElement(required = true)
    protected List<Stock> stock;

    /**
     * Gets the value of the stock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stock }
     * 
     * 
     */
    public List<Stock> getStocks() {
        if (stock == null) {
            stock = new ArrayList<Stock>();
        }
        return this.stock;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "Stock=" + stock +
                '}';
    }
}
