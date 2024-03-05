package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

class PaymentTest {
    private Map<String, String> paymentData;
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
    }

    void loadBankTransferPaymentData() {
        paymentData.put("bankName", "BCA");
        paymentData.put("referenceCode", "1234567890");
    }

    void loadVoucherCodePaymentData() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreatePaymentBankTransferStatusWaiting() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherStatusWaiting() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferStatusSuccess() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData,
                PaymentStatus.SUCCESS.getValue()
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherStatusSuccess() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData,
                PaymentStatus.SUCCESS.getValue()
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferStatusRejected() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData,
                PaymentStatus.REJECTED.getValue()
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherStatusRejected() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData,
                PaymentStatus.REJECTED.getValue()
        );
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e45d7d21-fd29-4533-a569-abbe0819579a", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferStatusInvalid() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new Payment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    "",
                    order,
                    paymentData,
                    "MEOW"
            );
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherStatusInvalid() {
        loadVoucherCodePaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new Payment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    "",
                    order,
                    paymentData,
                    "MEOW"
            );
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferStatusNull() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new Payment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    "",
                    order,
                    paymentData,
                    null
            );
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherStatusNull() {
        loadVoucherCodePaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new Payment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    "",
                    order,
                    paymentData,
                    null
            );
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentBankTransferSuccess() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentVoucherSuccess() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentBankTransferRejected() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentVoucherRejected() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentBankTransferInvalidStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("MEOW");
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentVoucherInvalidStatus() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("MEOW");
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentBankTransferNullStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment(
                "e45d7d21-fd29-4533-a569-abbe0819579a",
                "",
                order,
                paymentData
        );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus(null);
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusOfPaymentVoucherNullStatus() {
        loadVoucherCodePaymentData();
        Payment payment = new Payment
                (
                        "e45d7d21-fd29-4533-a569-abbe0819579a",
                        "",
                        order,
                        paymentData
                );
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus(null);
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentNullOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            Payment payment = new Payment(
                    "e45d7d21-fd29-4533-a569-abbe0819579a",
                    "",
                    null,
                    paymentData
            );
        });
    }
}