package com.pms.model.billing;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String customerName;
    private LocalDate invoiceDate;
    private Double totalAmount;
    private String paymentStatus;
}