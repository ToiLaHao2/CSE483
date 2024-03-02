package com.training;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database {
    // Declaring the database path, remember where you put your database
    private final static String DB_URL = "jdbc:sqlite:library.db";

    // Implement Method to add the book into the database
    static void addBook(String title, String author, String genre, String publicationDate, String isbn,
            boolean available) throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Databse Opened...\n");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO books (title,author,genre,publication_date,isbn,available) VALUES ('" + title
                    + "','" + author + "','" + genre + "','" + publicationDate + "','" + isbn + "'," + available + ")";
            stmt.executeUpdate(sql);
            System.out.println("Successfull adding new book");
            stmt.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Implement Method to add the borrower into the database
    static void addBorrower(String name, String email, String phone, String address) throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Databse Opened...\n");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO borrowers (name,email,phone,address) VALUES ('" + name
                    + "','" + email + "','" + phone + "','" + address + "')";
            stmt.executeUpdate(sql);
            System.out.println("Successfull adding new borrower");
            stmt.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Implement Method to add checkout into the database
    static void addCheckout(String bookID, String borrowerID, String coutdate, String duedate, String returnDate)
            throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Databse Opened...\n");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO checkouts (book_id,borrower_id,checkout_date,due_date,return_date) VALUES ("
                    + bookID
                    + "," + borrowerID + ",'" + coutdate + "','" + duedate + "','" + returnDate + "')";
            stmt.executeUpdate(sql);
            System.out.println("Successfull adding new borrower");
            stmt.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Implement Method to create database with the three columns books,borrowers
    // and checkouts
    static boolean createDatabase() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("database successfully created");
            System.out.println("Databse Opened...\n");
            Statement stmt = con.createStatement();
            String sql1 = "CREATE TABLE books (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, genre TEXT, publication_date TEXT, isbn TEXT NOT NULL, available INTEGER)";
            String sql2 = "CREATE TABLE checkouts (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, borrower_id INTEGER, checkout_date TEXT, due_date TEXT, return_date TEXT)";
            String sql3 = "CREATE TABLE borrowers (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, phone TEXT, address TEXT)";
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            System.out.println("Tables created successfully!");
            stmt.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    // Implement Method to delete the entry from the database given the id and the
    // table name
    static void delete(String tableName, String id) throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Databse Opened...\n");
            String sql = "DELETE FROM " + tableName.toLowerCase() + " WHERE id=" + id + ";";
            Statement stmt = con.createStatement();
            if (tableName.equals("books")) {
                stmt.executeUpdate(sql);
                String sql1 = "DELETE FROM checkouts WHERE book_id = " + id + ";";
                stmt.executeUpdate(sql1);
            } else if (tableName.equals("borrowers")) {
                stmt.executeUpdate(sql);
                String sql1 = "DELETE FROM checkouts WHERE borrower_id = " + id + ";";
                stmt.executeUpdate(sql1);
            }

            System.out.println("Delete success");
            stmt.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // Implement Method to refresh the tables with the updated data from the
    // database
    static void refreshTables(DefaultTableModel bookModel, DefaultTableModel borrowerModel,
            DefaultTableModel checkoutModel) {

        // You may look at the hint below for "Books tab", or just do it yourself

        bookModel.setRowCount(0);
        borrowerModel.setRowCount(0);
        checkoutModel.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String selectBooksQuery = "SELECT id, title, author, genre, publication_date, isbn, available FROM books";
            String selectBorrowerQuery = "SELECT id,name,email,phone,address FROM borrowers";
            String selectCheckoutQuery = "SELECT id,book_id,borrower_id,checkout_date,due_date,return_date FROM checkouts";

            PreparedStatement selectBooksStmt = conn.prepareStatement(selectBooksQuery);
            ResultSet bookResults = selectBooksStmt.executeQuery();

            PreparedStatement selectBorrowerStmt = conn.prepareStatement(selectBorrowerQuery);
            ResultSet borrowerResults = selectBorrowerStmt.executeQuery();

            PreparedStatement selectCheckoutStmt = conn.prepareStatement(selectCheckoutQuery);
            ResultSet checkOutResults = selectCheckoutStmt.executeQuery();

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

            while (borrowerResults.next()) {
                Object[] borrowerData = {
                        borrowerResults.getInt("id"),
                        borrowerResults.getString("name"),
                        borrowerResults.getString("email"),
                        borrowerResults.getString("phone"),
                        borrowerResults.getString("address")
                };
                borrowerModel.addRow(borrowerData);
            }

            while (checkOutResults.next()) {
                Object[] checkOutData = {
                        checkOutResults.getInt("id"),
                        checkOutResults.getInt("book_id"),
                        checkOutResults.getInt("borrower_id"),
                        checkOutResults.getString("checkout_date"),
                        checkOutResults.getString("due_date"),
                        checkOutResults.getString("return_date")
                };
                checkoutModel.addRow(checkOutData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
