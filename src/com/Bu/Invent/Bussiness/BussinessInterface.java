package com.Bu.Invent.Bussiness;

public interface BussinessInterface {
    public void Create(Products p) throws BussinessException;

    public void Delete(String productID) throws BussinessException;

    public void View() throws BussinessException;

    public void Update(String productid,Products products) throws BussinessException;
    public void Validate(String productid) throws BussinessException;
}