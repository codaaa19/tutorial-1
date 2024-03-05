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

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status) {
        this.id = id;
        this.method = method;
        this.setOrder(order);
        this.setPaymentData(paymentData);
        this.setStatus(status);
    }

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this(id, method, order, paymentData, PaymentStatus.WAITING_PAYMENT.getValue());
    }

    public void setStatus(String status) {
        if (!PaymentStatus.contains(status)) {
            throw new IllegalArgumentException("Invalid payment!");
        }

        this.status = status;
    }

    private void setOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be empty");
        }

        this.order = order;
    }

    public void setPaymentData(Map<String, String> paymentData) {
        if (PaymentMethod.contains(this.method)) {
            throw new IllegalArgumentException(
                    "Cannot set method-specific payment data for non-method-specific payment"
            );
        }

        this.paymentData = null;
    }
}