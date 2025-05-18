package com.likelion.likelionassignmentcrud.buy.api.dto.request;

public record BuySaveRequestDto(
        Long productId,
        String consumer
) {
}