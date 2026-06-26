package com.pms.controller;

import com.pms.dto.InvoiceRequest;
import com.pms.model.billing.Invoice;
import com.pms.model.billing.Payment;
import com.pms.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
        private  BillingService service;
    //constructor injection
//    public BillingController(BillingService service) {
//        this.service = service;
//    }
    @PostMapping("/invoice")
    public Invoice generateInvoice(@RequestBody InvoiceRequest request) {
        return service.createInvoice(request.getInvoice(), request.getItems());
    }

    @PostMapping("/pay/{invoiceId}")
    public Payment pay(@PathVariable Long invoiceId) {
        return service.processPayment(invoiceId);
    }

    @GetMapping
    public String home() {
        return "Billing API Running ✅";
    }

    @GetMapping("/all")
    public List<Invoice> getAllInvoices() {
        return service.getAllInvoices();
    }
}
