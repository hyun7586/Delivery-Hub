package org.example.deliveryhub.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.order.dto.OrderRequest;
import org.example.deliveryhub.domain.order.dto.OrderResponse;
import org.example.deliveryhub.domain.order.entity.Order;
import org.example.deliveryhub.domain.order.service.OrderService;
import org.example.deliveryhub.global.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

  private final OrderService orderService;



  // 주문 조회
  @GetMapping("/{order_id}")
  public ResponseEntity<ResponseApi<OrderResponse>> getOrder(
      @PathVariable(name="order_id") Long orderId
  ){
    OrderResponse responseData = orderService.getOrder(orderId);

    if(responseData==null)
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(ResponseApi.<OrderResponse>builder()
              .statusCode("404")
              .message("the data is not found")
              .data(null)
              .build());

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<OrderResponse>builder()
            .statusCode("200")
            .message("the data is found")
            .data(responseData)
            .build());
  }

  // 주문 생성
  @PostMapping("/")
  public ResponseEntity<ResponseApi<OrderResponse>> createOrder(
      @RequestBody OrderRequest request
  ){
    OrderResponse result = orderService.createOrder(request);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<OrderResponse>builder()
            .statusCode("200")
            .message("new order is created")
            .data(result)
            .build());
  }

  // 주문 삭제
  @DeleteMapping("/{order_id}")
  public ResponseEntity<ResponseApi<?>> deleteOrder(
      @PathVariable(name="order_id") Long orderId
  ){
    if(orderService.getOrder(orderId)==null)
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(ResponseApi.builder()
              .statusCode("404")
              .message("the data is not found")
              .data(null)
              .build());

    orderService.deleteOrder(orderId);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.builder()
            .statusCode("200")
            .message("the deletion is completed")
            .data(null)
            .build());
  }

  // 주문 수락/거절
  @GetMapping("/{order_id}/{command}")
  public ResponseEntity<ResponseApi<?>> updateOrderStatus(
      @PathVariable(name="order_id") Long orderId,
      @PathVariable(name="command") String command
  ){
    if(orderService.getOrder(orderId)==null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(ResponseApi.builder()
              .statusCode("404")
              .message("the data is not found")
              .data(null)
              .build());
    }

    OrderResponse responseData = orderService.updateOrderStatus(orderId, command);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<OrderResponse>builder()
            .statusCode("200")
            .message("the update is completed")
            .data(responseData)
            .build());
  }
}
