package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_Header;

import java.util.List;

public interface InvoiceRepository {

    public Invoice_Header getInvoice(int Id);
    public int save(Invoice_Header invoice_header);
}
