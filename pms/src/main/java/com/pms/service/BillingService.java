package com.pms.service;

import com.pms.model.billing.Invoice;
import com.pms.model.billing.InvoiceItem;
import com.pms.model.billing.Payment;
import com.pms.repo.billing.InvoiceItemRepository;
import com.pms.repo.billing.InvoiceRepository;
import com.pms.repo.billing.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BillingService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private InvoiceItemRepository itemRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    public Invoice createInvoice(Invoice invoice, List<InvoiceItem> items) {

        double totalAmount = 0;

        for (InvoiceItem item : items) {
            double itemTotal = item.getQuantity() * item.getPrice();
            item.setTotal(itemTotal);
            totalAmount += itemTotal;
        }

        invoice.setTotalAmount(totalAmount);
        invoice.setPaymentStatus("PENDING");

        Invoice savedInvoice = invoiceRepo.save(invoice);

        for (InvoiceItem item : items) {
            item.setInvoiceId(savedInvoice.getInvoiceId());
            itemRepo.save(item);
        }

        return savedInvoice;
    }
    public Payment processPayment(Long invoiceId) {

        Invoice invoice = invoiceRepo.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        invoice.setPaymentStatus("PAID");
        invoiceRepo.save(invoice);

        Payment payment = new Payment();
        payment.setInvoiceId(invoiceId);
        payment.setAmount(invoice.getTotalAmount());
        payment.setPaymentMethod("CASH");
        payment.setStatus("SUCCESS");

        return paymentRepo.save(payment);
    }
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }
}