package com.likelion.likelionassignmentcrud.product.api.dto.request;

import com.likelion.likelionassignmentcrud.product.domain.Part;

public record ProductSaveRequestDto(
        String name,
        int price,
        Part part
) {
}