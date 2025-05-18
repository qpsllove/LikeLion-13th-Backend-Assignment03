package com.likelion.likelionassignmentcrud.buy.application;

import com.likelion.likelionassignmentcrud.product.domain.Product;
import com.likelion.likelionassignmentcrud.product.domain.repository.ProductRepository;
import com.likelion.likelionassignmentcrud.buy.api.dto.request.BuySaveRequestDto;
import com.likelion.likelionassignmentcrud.buy.api.dto.response.BuyInfoResponseDto;
import com.likelion.likelionassignmentcrud.buy.api.dto.response.BuyListResponseDto;
import com.likelion.likelionassignmentcrud.buy.domain.Buy;
import com.likelion.likelionassignmentcrud.buy.domain.repository.BuyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BuyService {
    private final ProductRepository productRepository;
    private final BuyRepository buyRepository;

    // 게시물 저장
    @Transactional
    public void buySave(BuySaveRequestDto buySaveRequestDto) {
        Product product = productRepository.findById(buySaveRequestDto.productId()).orElseThrow(IllegalArgumentException::new);

        Buy buy = Buy.builder()
                .consumer(buySaveRequestDto.consumer())
                .product(product)
                .build();

        buyRepository.save(buy);
    }

    // 특정 작성자가 작성한 게시글 목록을 조회
    public BuyListResponseDto buyFindProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        List<Buy> buys = buyRepository.findByProduct(product);
        List<BuyInfoResponseDto> buyInfoResponseDtos = buys.stream()
                .map(BuyInfoResponseDto::from)
                .toList();

        return BuyListResponseDto.from(buyInfoResponseDtos);
    }
}