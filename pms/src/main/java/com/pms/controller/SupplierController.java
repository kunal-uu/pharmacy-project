package com.pms.controller;

import com.pms.model.Supplier;
import com.pms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Add supplier
    @PostMapping("/add")
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    // Get all
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable int id) {
        supplierService.deleteSupplier(id);
        return "Supplier deleted successfully";
    }
}