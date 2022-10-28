package com.Bu.Invent.UI;

import com.Bu.Invent.Bussiness.BussinessException;
import com.Bu.Invent.Bussiness.BussinessInterface;
import com.Bu.Invent.Bussiness.CRUDoperations;
import com.Bu.Invent.Bussiness.Products;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UIClass {
    Scanner scanner=new Scanner(System.in);

    Products products;
    void Getdata(){
        products=new Products();
        System.out.println("Enter Product ID");
        products.setProductID(scanner.next());
        System.out.println("Enter Productname");
        products.setProductName(scanner.next());
        System.out.println("Enter Description ");
        products.setDiscription(scanner.next());
        System.out.println("Enter Catagory");
        products.setCatagory(scanner.next());
        System.out.println("Enter Price");
        try {
            products.setPrice(scanner.nextDouble());
        } catch (InputMismatchException e){
            throw new UIException("Enter Price In Numbers Only");
        }

    }
    void Operations()  {
        int input;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Input");
            System.out.println("1.Create");
            System.out.println("2.Delete");
            System.out.println("3.View");
            System.out.println("4.Update");
            System.out.println("5.Exit");
            try {
                input = s.nextInt();
                if (input >= 6) {
                    throw new UIException("Enter Corresponding Input");
                }
            } catch (InputMismatchException e) {
                throw new UIException("Enter Valid Input");
            }
            switch (input) {
                case 1:
                    Getdata();
                    BussinessInterface create = new CRUDoperations();
                    try {
                        create.Create(products);
                    }
                    catch (BussinessException e){
                        throw new UIException(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Enter Product ID");
                    String productid = scanner.next();
                    BussinessInterface delete = new CRUDoperations();
                    try {
                        delete.Delete(productid);
                    }
                    catch (BussinessException e){
                        throw new UIException(e.getMessage());
                    }

                    break;
                case 3:
                    BussinessInterface view = new CRUDoperations();
try {
    view.View();
}
catch (BussinessException e){
    throw new UIException(e.getMessage());
}

                    break;
                case 4:
                    System.out.println("Enter Product ID to Upadate");
                    String productID = scanner.next();
                    BussinessInterface Update = new CRUDoperations();
                    try {

                        Update.Validate(productID);
                        Getdata();
                        Update.Update(productID, products);
                    } catch (BussinessException e){
                        throw new UIException(e.getMessage());
                    }

                    break;
            }
        }
            while (input < 6) ;

        }
    public static void main(String[] args) {
        UIClass u=new UIClass();
        try {
            u.Operations();
        }
        catch (UIException e){
            System.out.println(e.getMessage());
        }

    }
}
