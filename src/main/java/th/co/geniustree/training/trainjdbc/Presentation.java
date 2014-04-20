/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.training.trainjdbc;

import java.util.List;

/**
 *
 * @author Nook
 */
public class Presentation {
    private Drug drug;
    
    
    public void print(){
        DAO dao = new DAO();
        List<Drug> result=dao.getData();
        for (Drug drug:result){
            System.out.println(drug.getId()+"\t"+drug.getName());
        }
    }
    
}
