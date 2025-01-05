package org.example.deliveryhub.domain.order.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.order.dto.OrderResponse;
import org.example.deliveryhub.domain.order.entity.Order;
import org.example.deliveryhub.domain.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/order")
public class OrderAdminController {
  private final OrderRepository orderRepository;

  // 특정 메뉴 조회
  @GetMapping("/{order_id}")
  public ResponseEntity<Optional<Order>> getAdminOrder(
      @PathVariable(name="order_id") Long orderId
  ){
    return ResponseEntity.status(HttpStatus.OK)
        .body(orderRepository.findById(orderId));
  }

  // 메뉴 리스트 조회
  @GetMapping("/all")
  public ResponseEntity<List<Order>> getAdminOrderList(){
    return ResponseEntity.status(HttpStatus.OK)
        .body(orderRepository.findAll());
  }

}
