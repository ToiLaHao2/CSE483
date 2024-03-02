package com.training;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database  {
//	 Declaring the database path, remember where you put your database  
	  private final static String DB_URL = "jdbc:sqlite:library.db";

//	  Implement Method to add the book into the database
	    static void addBook(String title, String author, String genre, String publicationDate, String isbn, boolean available) throws SQLException {           
	    }
//	   Implement Method to add the borrower into the database 
	    static void addBorrower(String name, String email, String phone, String address)throws SQLException {            
	    }
	    
//	    Implement Method to add checkout into the database
	    static void addCheckout(String bookID,String borrowerID,String coutdate,String duedate ,String returnDate)throws SQLException {
	    }
	    
//	    Implement Method to create database with the three columns books,borrowers and checkouts
    static void createDatabase() {
    }

//    Implement Method to delete the entry from the database given the id and the table name
    static void delete(String tableName,String id) throws SQLException {           
	}
    
//    Implement Method to refresh the tables with the updated data from the database 
    static void refreshTables(DefaultTableModel bookModel, DefaultTableModel borrowerModel, DefaultTableModel checkoutModel) {
        
    	//You may look at the hint below for "Books tab", or just do it yourself
    	/*
    	bookModel.setRowCount(0);


        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String selectBooksQuery = "SELECT id, title, author, genre, publication_date, isbn, available FROM books";
            PreparedStatement selectBooksStmt = conn.prepareStatement(selectBooksQuery);
            ResultSet bookResults = selectBooksStmt.executeQuery();
            while (bookResults.next()) {
                Object[] bookData = {
                        bookResults.getInt("id"),
                        bookResults.getString("title"),
                        bookResults.getString("author"),
                        bookResults.getString("genre"),
                        bookResults.getString("publication_date"),
                        bookResults.getString("isbn"),
                        bookResults.getBoolean("available")
                };
                bookModel.addRow(bookData);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
     */  
    }
   	
}
