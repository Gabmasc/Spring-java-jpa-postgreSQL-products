package com.products_DatabaseConnective.startUp.productRecordsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(@NotBlank String nameProduct,@NotNull BigDecimal valueProduct) {
}
