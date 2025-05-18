package com.likelion.likelionassignmentcrud.product.api;

import com.likelion.likelionassignmentcrud.product.api.dto.request.ProductSaveRequestDto;
import com.likelion.likelionassignmentcrud.product.api.dto.response.ProductInfoResponseDto;
import com.likelion.likelionassignmentcrud.product.api.dto.response.ProductListResponseDto;
import com.likelion.likelionassignmentcrud.product.application.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    // 사용자 저장
    @PostMapping("/save")
    public ResponseEntity<String> productSave(@RequestBody ProductSaveRequestDto productSaveRequestDto) {
        productService.productSave(productSaveRequestDto);
        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    // 사용자 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ProductListResponseDto> productFindAll() {
        ProductListResponseDto productListResponseDto = productService.productFindAll();
        return new ResponseEntity<>(productListResponseDto, HttpStatus.OK);
    }

    // 회원 id를 통해 특정 사용자 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfoResponseDto> productFindOne(@PathVariable("productId") Long productId) {
        ProductInfoResponseDto productInfoResponseDto = productService.productFindOne(productId);
        return new ResponseEntity<>(productInfoResponseDto, HttpStatus.OK);
    }
}