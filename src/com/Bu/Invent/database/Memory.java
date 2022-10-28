package com.Bu.Invent.database;


import com.Bu.Invent.Bussiness.Products;

import java.util.HashMap;


public class Memory implements Interfacedatabase {

private static Memory memory=new Memory();

    public static Memory getMemory() {
        return memory;
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
                    System.out.println(productdetails);
                    System.out.println("Added Successfully");

            }


        }

        @Override
        public void Delete(String Id) {
            if(productdetails.containsKey(Id)){
                productdetails.remove(Id);
                System.out.println("Delete Successfully");
            }
            else if (productdetails.isEmpty()){
                throw new RuntimeException("Database Is Empty");
            }
            else{
                throw new RuntimeException("Invalid ProductId");

            }

        }

        @Override
        public void View() throws DatabaseException {
            if (productdetails.isEmpty()) {

                throw new DatabaseException("No Records Found");
            } else {
               // System.out.println("view");
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






