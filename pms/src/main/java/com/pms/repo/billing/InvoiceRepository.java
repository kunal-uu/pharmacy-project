package com.pms.repo.billing;

import com.pms.model.billing.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
//package com.pms.repo.billing;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}