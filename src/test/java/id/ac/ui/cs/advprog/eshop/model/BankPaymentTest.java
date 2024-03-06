package id.ac.ui.cs.advprog.eshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import static org.junit.jupiter.api.Assertions.*;

class BankPaymentTest {
    Map<String, String> paymentData;
    private Order order;
    private List<Product> products;

    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<>();

        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("e45d7d21-fd29-4533-a569-abbe0819579a");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("8a76b99c-a0b3-46d2-a688-4c1831b21119");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        products.add(product2);

        order= new Order(
                "dbd4aff4-9a7f-4603-92c2-eaf529271cc9",
                products,
                1708560000L,
                "Safira Sudrajat"
        );

        paymentData.put("bankName", "BCA");
        paymentData.put("referenceCode", "1234567890");
    }

    @Test
    void testCreateBankPaymentWaitStatus() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        assertSame(order, payment.getOrder());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
    }

    @Test
    void testCreateBankPaymentSuccessStatus() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData,
                PaymentStatus.SUCCESS.getValue()
        );
        assertSame(order, payment.getOrder());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreateBankPaymentRejectedStatus() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData,
                PaymentStatus.REJECTED.getValue()
        );
        assertSame(order, payment.getOrder());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreateBankPaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData,
                    "HAIIII"
            );
        });
    }

    @Test
    void testCreateBankPaymentNullStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData,
                    null
            );
        });
    }

    @Test
    void testSetBankPaymentStatStatusSuccess() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetBankPaymentStatStatusRejected() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetBankPaymentStatStatusWait() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.WAITING_PAYMENT.getValue());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
    }

    @Test
    void testSetBankPaymentStatStatusInvalid() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("HAIIII");
        });
    }

    @Test
    void testSetBankPaymentStatStatusNull() {
        Payment payment = new BankPayment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                PaymentMethod.BANK.getValue(),
                order,
                paymentData
        );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus(null);
        });
    }

    @Test
    void testCreateBankPaymentNullOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    null,
                    paymentData
            );
        });
    }

    @Test
    void testCreateBankPaymentEmptyPayment() {
        paymentData.clear();
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData
            );
        });
    }

    @Test
    void testCreateBankPaymentNullPayment() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    null
            );
        });
    }

    @Test
    void testCreateBankPaymentInvalidBank() {
        paymentData.put("bankName", "");
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData
            );
        });
    }

    @Test
    void testCreateBankPaymentInvalidCode() {
        paymentData.put("referenceCode", "");
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData
            );
        });
    }

    @Test
    void testCreateBankPaymentNullBank() {
        paymentData.put("bankName", null);
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData
            );
        });
    }

    @Test
    void testCreateBankPaymentNullCode() {
        paymentData.put("referenceCode", null);
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new BankPayment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    PaymentMethod.BANK.getValue(),
                    order,
                    paymentData
            );
        });
    }

}