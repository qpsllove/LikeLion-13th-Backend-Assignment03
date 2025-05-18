package com.likelion.likelionassignmentcrud.buy.api;

import com.likelion.likelionassignmentcrud.buy.api.dto.request.BuySaveRequestDto;
import com.likelion.likelionassignmentcrud.buy.api.dto.response.BuyListResponseDto;
import com.likelion.likelionassignmentcrud.buy.application.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buy")
public class BuyController {
    private final BuyService buyService;

    // 게시물 저장
    @PostMapping("/save")
    public ResponseEntity<String> buySave(@RequestBody BuySaveRequestDto buySaveRequestDto) {
        buyService.buySave(buySaveRequestDto);
        return new ResponseEntity<>("게시물 저장!", HttpStatus.CREATED);
    }

    // 사용자 id를 기준으로 해당 사용자가 작성한 게시글 목록 조회
    @GetMapping("/{productId}")
    public ResponseEntity<BuyListResponseDto> myBuyFindAll(@PathVariable("productId") Long productId) {
        BuyListResponseDto buyListResponseDto = buyService.buyFindProduct(productId);
        return new ResponseEntity<>(buyListResponseDto, HttpStatus.OK);
    }
}