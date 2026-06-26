package com.pms.model.billing;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Long invoiceId;
    private String medicineName;
    private int quantity;
    private double price;
    private Double total;
}