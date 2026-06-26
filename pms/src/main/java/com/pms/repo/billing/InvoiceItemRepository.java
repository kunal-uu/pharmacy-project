package com.pms.repo.billing;

import com.pms.model.billing.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
}