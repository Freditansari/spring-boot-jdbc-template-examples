package com.merdekacloud.JdbcTemplate.Repositories;

import com.merdekacloud.JdbcTemplate.Entity.Invoice_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("InvoiceDetailsRepo")
public class InvoiceDetailsRepoImpl implements  InvoiceDetailsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Invoice_details> getInvoiceDetails(int invoice_id) {


        return jdbcTemplate.query(
                "SELECT * FROM public.invoice_details where invoice_id ="+invoice_id,
                (rs, rowNum) ->
                        new Invoice_details(
                                rs.getLong("detail_id"),
                                rs.getInt("invoice_id"),
                                rs.getString("product_name"),
                                rs.getLong("qty"),
                                rs.getBigDecimal("total_price")
                        )
                );
    }
}
