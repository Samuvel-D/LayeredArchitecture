package com.Bu.Invent.database;

import com.Bu.Invent.Bussiness.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileClass implements Interfacedatabase {
  private static   FileClass f=new FileClass();

    public static FileClass getF() {
        return f;
    }

    HashMap<String, Products> productdetails = new HashMap<>();
    @Override

    public void Add(Products products) throws DatabaseException {

        if(products.getPrice()<=0) {
            throw new DatabaseException("Price Should Be Greater Than Zero");

        }
        else if (productdetails.containsKey(products.getProductID())) {
            throw new DatabaseException("Product ID Already Exist");

        }
        else {

            productdetails.put(products.getProductID(),products);
            try {
                ArrayList<Products> l=new ArrayList();
//                FileWriter f=new FileWriter("Filedata");
//                f.append((CharSequence) productdetails);
                FileOutputStream f=new FileOutputStream("File");
            }
          catch (IOException e){
                throw new DatabaseException("File");
          }
            System.out.println("Added Successfully");

        }


    }

    @Override
    public void Delete(String Id) throws DatabaseException {
        if(productdetails.containsKey(Id)){
            productdetails.remove(Id);
            System.out.println("Delete Successfully");
        }
        else if (productdetails.isEmpty()){
            throw new DatabaseException("Database Is Empty");
        }
        else{
            throw new DatabaseException("Invalid ProductId");

        }

    }

    @Override
    public void View() throws DatabaseException {
        if (productdetails.isEmpty()) {

            throw new DatabaseException("No Records Found");
        } else {
            System.out.println("view");
            productdetails.forEach((k, v)-> System.out.println(k + " " + v));
        }

    }

    @Override
    public void Update(String productid,Products products)  {
        if (productdetails.containsKey(productid)) {
            productdetails.replace(productid,products);
            System.out.println("Added Successfully");
        }
    }
    @Override
    public void validate(String productid) throws DatabaseException {
        if(productdetails.isEmpty()){
            throw new DatabaseException("Database is Empty");
        } else if (productdetails.containsKey(productid)) {
            System.out.println("You Can Update");
        }
        else {
            throw new DatabaseException("Invalid ProdutID");
        }
    }
}
