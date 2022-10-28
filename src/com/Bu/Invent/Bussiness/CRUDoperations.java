package com.Bu.Invent.Bussiness;


import com.Bu.Invent.database.*;

public class CRUDoperations implements BussinessInterface {


    @Override

    public void Create(Products products) throws BussinessException {
        Interfacedatabase create = FileClass.getF();
        try {
            create.Add(products);
        }
        catch ( DatabaseException e){
            throw new BussinessException(e.getMessage());
        }
    }

    @Override
    public void Delete(String productid) throws BussinessException {

        Interfacedatabase delete= FileClass.getF();

        try {
            delete.Delete(productid);
        }
        catch (DatabaseException e){
            throw new BussinessException(e.getMessage());
        }
    }


    @Override
    public void View() throws BussinessException {

        Interfacedatabase view =FileClass.getF();
        try {
            view.View();
        }
        catch (DatabaseException e){
            throw new BussinessException(e.getMessage());
        }


    }
    @Override
    public void Update(String productid,Products products) throws BussinessException {
        Interfacedatabase update=FileClass.getF();
        try {
            update.Update(productid,products);
        } catch (DatabaseException e){
            throw new BussinessException(e.getMessage());
        }

    }


    public void Validate(String productid) throws BussinessException {
        Interfacedatabase update=FileClass.getF();
        try {
            update.validate(productid);
        } catch (DatabaseException e){
            throw new BussinessException(e.getMessage());
        }
    }
}
