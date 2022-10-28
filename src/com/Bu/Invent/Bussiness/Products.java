package com.Bu.Invent.Bussiness;

public class Products {



  String ProductID;
  String Productcode;

    String ProductName;
    String Discription;
    String Catagory;
    Double Price;


    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductcode() {
        return Productcode;
    }

    public void setProductcode(String productcode) {
        Productcode = productcode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "ProductID='" + ProductID + '\'' +
                ", Productcode='" + Productcode + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Discription='" + Discription + '\'' +
                ", Catagory='" + Catagory + '\'' +
                ", Price=" + Price +
                '}';
    }
}
