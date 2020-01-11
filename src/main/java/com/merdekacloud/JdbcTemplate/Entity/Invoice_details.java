package com.merdekacloud.JdbcTemplate.Entity;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice_details {

    private Long detail_id;
    private int invoice_id;
    private String product_name;
    private Long qty;

    @NotEmpty(message = "total price should not be empty")
    private BigDecimal total_price;
}
