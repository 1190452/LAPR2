/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Freelancer;
import Model.Payment;
import Model.PaymentList;
import Model.Platform;
import Model.RegisterFreelancer;
import java.util.List;
import java.util.Set;

/**
 *
 * @author OMEN X
 */
public class CheckPerformanceController {
    
    private Platform platform;
    
    public CheckPerformanceController(){
        platform = new Platform();
    }
    
    public void getPerformances(){
        RegisterFreelancer rFree = platform.getRfree();
        List<Freelancer> listFreelancer = rFree.getListFreelancer();
        for (int i=0; i< listFreelancer.size(); i++){
            Freelancer freel = listFreelancer.get(i);
            PaymentList pl = freel.getPaymentList();
            List<Payment> listPayment = pl.getPaymentList();
        }
    }
}
