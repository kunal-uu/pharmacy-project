package com.pms.repo.billing;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pms.model.billing.Payment;   // ✅ import your entity

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}