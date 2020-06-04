/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jorge
 */
public enum NewEnum {
    
    JUNIOR("Junior"),
    SENIOR("SENIOR");
    
    private String label;

    private NewEnum(String label) {
        this.label = label;
    }

    
    
    public String toString() {
        return label;
    }
}
