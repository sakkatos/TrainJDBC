/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.training.trainjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nook
 */
public class DAO {
    public List<Drug> getData() {
        Connection connection=null;
        String sqlQuery = "SELECT *";
        List<Drug> drugs = new ArrayList<>();
        
        
        try {
            //jdbc:oracle:thin:@192.168.1.126:1521:testdb
            //OPENASTHMAOWNER
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.126:1521:testdb", "OPENASTHMAOWNER", "computer");
            Statement createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery("SELECT * FROM drug");
          
            while (executeQuery.next()){
                Drug drug = new Drug();
                drug.setId(executeQuery.getString("DRUGID"));
                drug.setName(executeQuery.getString("DRUGNAME"));
                drugs.add(drug);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       return drugs;   
    }
}
