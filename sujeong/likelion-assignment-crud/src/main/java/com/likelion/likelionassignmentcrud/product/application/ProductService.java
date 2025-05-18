package com.likelion.likelionassignmentcrud.product.application;

import java.util.List;

import com.likelion.likelionassignmentcrud.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.likelionassignmentcrud.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.likelionassignmentcrud.product.api.dto.response.ProductListResponseDto;
import com.likelion.likelionassignmentcrud.product.domain.Product;
import com.likelion.likelionassignmentcrud.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    // 사용자 정보 저장
    @Transactional
    public void productSave(ProductSaveRequestDto productSaveRequestDto) {
        Product product = Product.builder()
                .name(productSaveRequestDto.name())
                .price(productSaveRequestDto.price())
                .part(productSaveRequestDto.part())
                .build();
        productRepository.save(product);
    }

    // 사용자 모두 조회
    public ProductListResponseDto productFindAll() {
        List<Product> products = productRepository.findAll();
        List<ProductInfoResponseDto> productInfoResponseDtoList = products.stream()
                .map(ProductInfoResponseDto::from)
                .toList();
        return ProductListResponseDto.from(productInfoResponseDtoList);
    }

    // 단일 사용자 조회
    public ProductInfoResponseDto productFindOne(Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(IllegalArgumentException::new);
        return ProductInfoResponseDto.from(product);
    }
}