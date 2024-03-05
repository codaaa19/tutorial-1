package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

import java.util.List;
import java.util.Map;

@Builder
@Getter
public class Payment {
    String id;
    Map<String,String> paymentData;
    String method;
    String status;

    public Payment (String id, Map<String,String> paymentData, String method){
        this.id = id;
        this.method = method;
        this.status = OrderStatus.WAITING_PAYMENT.getValue();

        if(paymentData.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, Map<String,String> paymentData, String method, String status){
        this(id,paymentData,method);
        this.setStatus(method, status);
    }

    public void setStatus(String payment,String status) {
        if (OrderStatus.contains(status)){
            this.status = status;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

