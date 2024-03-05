package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

@Builder
@Getter
public class Payment {
    String id;
    String method;
    Order order;
    Map<String, String> paymentData;
    String status;

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.order = order;
        this.paymentData = paymentData;
        this.status = "WAITING_PAYMENT";

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be empty");
        }

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data cannot be empty");
        }

        if (method.isEmpty()) {
            throw new IllegalArgumentException("Payment method cannot be empty");
        }

        if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException("Invalid payment method!");
        }

        if (method.equals(PaymentMethod.VOUCHER.getValue()) && !paymentData.containsKey("voucherCode")) {
            throw new IllegalArgumentException("A valid voucher code must be provided for voucher payment.");
        }

        if (method.equals(PaymentMethod.BANK.getValue()) && (!paymentData.containsKey("bankName") || !paymentData.containsKey("referenceCode"))) {
            throw new IllegalArgumentException("Bank name and reference code must be provided for bank payment");
        }
    }

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status) {
        this(id, method, order, paymentData);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (!PaymentStatus.contains(status)) {
            throw new IllegalArgumentException("Invalid!");
        }

        this.status = status;
    }
}