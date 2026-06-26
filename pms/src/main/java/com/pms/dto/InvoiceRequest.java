package com.pms.dto;//package com.example.billing.dto;

import com.pms.model.billing.Invoice;
import com.pms.model.billing.InvoiceItem;
import lombok.*;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
    private Invoice invoice;
    private List<InvoiceItem> items;
}