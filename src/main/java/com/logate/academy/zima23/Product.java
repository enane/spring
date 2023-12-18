package com.logate.academy.zima23;

public class Product {

    private int id;
    private String name;
    private String descp;
    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descp='" + descp + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {
    }

    public Product(Integer id, String name, String descp, Double price) {
        this.id = id;
        this.name = name;
        this.descp = descp;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
