package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Order;

import java.util.Map;

public interface PaymentService {
    public Payment addPayment (Order order, String method, Map<String,String> paymentData);
    public Payment getPayment (String paymentId);
    public Payment getAllPayments();
    Payment setStatus(String id, String status);
}
