package com.Bu.Invent.database;


import com.Bu.Invent.Bussiness.BussinessException;
import com.Bu.Invent.Bussiness.Products;

import java.util.ArrayList;
import java.util.HashMap;

public interface Interfacedatabase {


    public void Add(Products p) throws DatabaseException, BussinessException;
    public void Delete(String productid) throws DatabaseException;
    public void View() throws DatabaseException;
    public void Update(String productid,Products p) throws DatabaseException;
    public void validate(String productid) throws DatabaseException;


}