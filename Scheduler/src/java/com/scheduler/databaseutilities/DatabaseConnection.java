/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scheduler.databaseutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.swing.JOptionPane;

/**
 *
 * @author towers
 */
@Named
@Dependent
public class DatabaseConnection {
	private Connection conn;
	private JOptionPane op;
	private Statement stmn = null;
	private ResultSet rs=null;
	
	public DatabaseConnection(){}
	public void createDatabaseConnection(String databaseName,
                String databaseUser,
                String databasePassword){
            System.out.println( "db 4rm dbcon"+databaseName+" "+databaseUser+" "+databasePassword);
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			try {   System.out.println( "db 4rm dbcon round 2 "+databaseName+" "+databaseUser+" "+databasePassword);
				//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/'"+databaseName+"'"+","+databaseUser+","+databasePassword);
                        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/persistence","root", "duncantowers");
				System.out.println("connection estblished");
			} catch (SQLException e) {
                            e.printStackTrace();
                        }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public ResultSet executeQuery(String query){
                
		Statement stmn = null;
		ResultSet rs=null;
		try {
			stmn = conn.createStatement();
			rs=stmn.executeQuery(query);
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
                }
		return rs;
	}
	public boolean execute(String query){
		Statement stmn;
		Boolean rs=false;
		try {
			stmn = conn.createStatement();
			rs=stmn.execute(query);
			rs=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
                }
		
		return rs;
	}

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public JOptionPane getOp() {
        return op;
    }

    public void setOp(JOptionPane op) {
        this.op = op;
    }

    public Statement getStmn() {
        return stmn;
    }

    public void setStmn(Statement stmn) {
        this.stmn = stmn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
	
       
}
