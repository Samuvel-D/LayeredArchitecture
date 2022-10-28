package com.Bu.Invent.database;

import com.Bu.Invent.Bussiness.BussinessException;
import com.Bu.Invent.Bussiness.Products;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Databaseclass implements Interfacedatabase {
    private static Databaseclass databaseclass = new Databaseclass();

    public static Databaseclass getInstance() {
        return databaseclass;
    }


    Connection Connection() throws DatabaseException {

        Connection con=null;
        try {
            FileReader propertyfile = new FileReader("D:\\file\\Property.properties");
            Properties p = new Properties();
            p.load(propertyfile);
            String url = p.getProperty("url");
            String user = p.getProperty("user");
            String password = p.getProperty("password");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            propertyfile.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new DatabaseException(e.getMessage());
        }

        return con;
    }


    @Override
    public void Add(Products products) throws DatabaseException {
        Connection con=null;
        try {
           con=Connection();
            PreparedStatement pstm;
            pstm = con.prepareStatement("insert into productssam values(?,?,?,?,?);");
            pstm.setString(1, products.getProductID());
            pstm.setString(2, products.getProductName());
            pstm.setString(3, products.getDiscription());
            pstm.setString(4, products.getCatagory());
            pstm.setDouble(5, products.getPrice());
            pstm.executeUpdate();
            System.out.println("Added Successfully");
        } catch (SQLException e) {
            throw new DatabaseException("ProductId Already Exist");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }

        }
    }

    @Override
    public void Delete(String id) throws DatabaseException {
        Connection con = null;
        try {
            con = Connection();
            PreparedStatement pstm;
            pstm = con.prepareStatement("delete from productssam where Pid=?");
            pstm.setString(1, id);
            pstm.executeUpdate();
            System.out.println("Deleted Successfully");
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }
        }

    }

    @Override
    public void View() throws DatabaseException {
            Connection con=null;
        try {
            con=Connection();
            PreparedStatement pstm;
            pstm=con.prepareStatement("select * from productssam");
            ResultSet st=pstm.executeQuery();
            while (st.next()){
                System.out.println("ProductID="+st.getString(1)+" "+"ProductName="+st.getString(2)+" "+"Discription="+st.getString(3)
                        +" "+"Catagory="+st.getString(4)+" "+"Price="+st.getString(5 ));


            }
        }
        catch (SQLException e){
            throw new DatabaseException(e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException e){
                throw new DatabaseException(e.getMessage());
            }

        }

    }

    @Override
    public void Update(String productid, Products products) throws DatabaseException {
        Connection con=null;
        try{
             con=Connection();
            PreparedStatement pstm;
            pstm = con.prepareStatement("update  productssam set PName= ?,  Discription= ?, Catagory= ? ,Price= ? where Pid="+productid+" ;");
            //  pstm.setString(1, products.getProductId());
            pstm.setString(1, products.getProductName());
            pstm.setString(2, products.getDiscription());
            pstm.setString(3, products.getCatagory());
            pstm.setDouble(4, products.getPrice());
            pstm.executeUpdate();
            System.out.println("***Updated Successfully***");

        }
        catch(SQLException e){
            throw new DatabaseException(e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (SQLException e){
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String productid) throws DatabaseException {
        Connection con=null;
        String check=null;
        try{
            con=Connection();
            PreparedStatement pstm;
            pstm = con.prepareStatement("select Pid from productssam where Pid=?;");
            pstm.setString(1,productid);
           ResultSet re=pstm.executeQuery();
           if(re.next()){
               check=re.getString(1);
           }
           if (check==null){
               throw new DatabaseException("Invalid Productid");
           }
        }
        catch (SQLException e){
            throw new DatabaseException(e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DatabaseException(e.getMessage());
            }

        }


    }

}

