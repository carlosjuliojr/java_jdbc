package org.julio.java.jdbc.model;

import java.util.Date;

/**
 * The type Product.
 */
public class Product {

    private Long id;
    private String name;
    private Integer price;
    private Date dateRegister;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param id           the id
     * @param name         the name
     * @param price        the price
     * @param dateRegister the date register
     */
    public Product(Long id, String name, Integer price, Date dateRegister) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateRegister = dateRegister;
    }

    public Product(String name, Integer price, Date dateRegister) {
        this.name = name;
        this.price = price;
        this.dateRegister = dateRegister;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Gets date register.
     *
     * @return the date register
     */
    public Date getDateRegister() {
        return dateRegister;
    }

    /**
     * Sets date register.
     *
     * @param dateRegister the date register
     */
    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateRegister=" + dateRegister +
                '}';
    }
}
