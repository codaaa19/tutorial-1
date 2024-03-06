package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;
import lombok.Getter;

@Getter
public class VoucherPayment extends Payment {
    public VoucherPayment(String id, String method, Order order, Map<String, String> paymentData) {
        super(id, method, order, paymentData);
    }

    public VoucherPayment(String id, String method, Order order, Map<String, String> paymentData, String status) {
        super(id, method, order, paymentData, status);
    }

    @Override
    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data cannot be empty");
        }

        if (paymentData.get("voucherCode") == null || paymentData.get("voucherCode").isEmpty()) {
            throw new IllegalArgumentException("Voucher code cannot be empty");
        }

        if (!isVoucherValid(paymentData.get("voucherCode"))) {
            throw new IllegalArgumentException("Invalid voucher code");
        }
        this.paymentData = paymentData;
    }

    private boolean isVoucherValid(String voucherCode) {
        if (voucherCode.length() != 16 ||
                !voucherCode.startsWith("ESHOP") ||
                countNumericsInVoucher(voucherCode) != 8) {
            return false;
        }

        return true;
    }

    private int countNumericsInVoucher(String voucherCode) {
        int numericCount = 0;
        for (int i = 0; i < voucherCode.length(); i++) {
            if (Character.isDigit(voucherCode.charAt(i))) {
                numericCount++;
            }
        }
        return numericCount;

    }

    private long numericsInVoucherCounter(String voucherCode) {
        long totalNum = 0;
        for (char c : voucherCode.toCharArray()) {
            if (Character.isDigit(c)) {
                totalNum++;
            }
        }
        return totalNum;
    }
}