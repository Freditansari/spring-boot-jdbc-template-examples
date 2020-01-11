package com.merdekacloud.JdbcTemplate.Controllers;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_Header;
import com.merdekacloud.JdbcTemplate.Repositories.InvoiceRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
    @Autowired
    @Qualifier("invoiceRepository")
    private InvoiceRepoImpl invoiceRepo;

    @GetMapping("/invoice/")
    public Invoice_Header getInvoiceById(@RequestParam("id") int id){
        return invoiceRepo.getInvoice(id);
    }
}
