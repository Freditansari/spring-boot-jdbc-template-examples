package com.merdekacloud.JdbcTemplate.Controllers;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_Header;
import com.merdekacloud.JdbcTemplate.Repositories.InvoiceRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvoiceController {
    @Autowired
    @Qualifier("invoiceRepository")
    private InvoiceRepoImpl invoiceRepo;

    @GetMapping("/invoice/")
    public Invoice_Header getInvoiceById(@RequestParam("id") int id){
        return invoiceRepo.getInvoice(id);
    }

    @PostMapping("/invoice")
    public int saveInvoice(@Valid @RequestBody Invoice_Header invoiceHeader){
        return invoiceRepo.save(invoiceHeader);
    }
}
