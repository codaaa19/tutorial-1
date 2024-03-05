package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentRepository {
    private List<Payment> paymentData = new ArrayList<>();

    public Payment save(Payment payment){
        int i = 0;
        for (Payment savedPayment : paymentData){
            if (savedPayment.getId().equals(payment.getId())){
                paymentData.remove(i);
                paymentData.add(i,payment);
                return  payment;
            }
            i += 1;
        }
        paymentData.add(payment);
        return payment;
    }

    public Payment findById(String id){
        for (Payment curPayment : paymentData){
            if(curPayment.getId().equals(id)){
                return curPayment;
            }
        }
        return  null;
    }

//    public List<Payment> findAllPaymentByAuthor (String author){
//        List<Payment> result = new ArrayList<>();
//        for (Payment savedPayment : paymentData){
//            if (savedPayment.get)
//        }
//    }
}
