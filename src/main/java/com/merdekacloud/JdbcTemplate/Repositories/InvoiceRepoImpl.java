package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_Header;
import com.merdekacloud.JdbcTemplate.Entity.Invoice_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

/*
* JdbcTemplate example on querying master detail relationship
* */
@Repository("invoiceRepository")
public class InvoiceRepoImpl implements InvoiceRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("InvoiceDetailsRepo")
    private  InvoiceDetailsRepoImpl invoiceDetailsRepo;
    @Override
    public Invoice_Header getInvoice(int id) {

        Invoice_Header ih = jdbcTemplate.queryForObject(
                "SELECT * FROM public.invoice_header where invoice_id ="+ id,
                (rs, rowNum) -> new Invoice_Header(
                        rs.getLong("invoice_id"),
                        rs.getString("invoice_to"),
                        rs.getString("email"),
                        rs.getBigDecimal("subtotal"),
                        rs.getBigDecimal("discount"),
                        rs.getBigDecimal("total")
                ));

       ih.setInvoice_details(invoiceDetailsRepo.getInvoiceDetails(id));


        return ih;
    }

    @Override
    public int save(Invoice_Header invoice_header) {
        return 0;
    }
}

//public class Invoice_headerRowMapper implements RowMapper<Invoice_Header>{
//
//    @Override
//    public Invoice_Header mapRow(ResultSet rs, int i) throws SQLException {
//        Invoice_Header ih = new Invoice_Header();
//
//        ih.setInvoice_id(rs.getLong("invoice_id"));
//        ih.setInvoice_to(rs.getString("invoice_to"));
//        ih.setEmail(rs.getString("email"));
//        ih.setSubtotal(rs.getBigDecimal("subtotal"));
//        ih.setDiscount(rs.getBigDecimal("discount"));
//        ih.setTotal(rs.getBigDecimal("total"));
//
//        return ih;
//    }
//}
