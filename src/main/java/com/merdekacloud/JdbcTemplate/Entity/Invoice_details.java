package com.merdekacloud.JdbcTemplate.Entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice_details {

    private Long detail_id;
    private Long invoice_id;
    private String product_name;
    private Long qty;
    private BigDecimal total_price;
}
