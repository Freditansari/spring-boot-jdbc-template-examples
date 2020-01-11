package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_details;

import java.util.List;

public interface InvoiceDetailsRepository {
    public List<Invoice_details> getInvoiceDetails(int invoice_id);
}
