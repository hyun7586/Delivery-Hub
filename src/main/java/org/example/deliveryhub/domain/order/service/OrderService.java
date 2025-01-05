package org.example.deliveryhub.domain.order.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.order.dto.OrderRequest;
import org.example.deliveryhub.domain.order.dto.OrderResponse;
import org.example.deliveryhub.domain.order.entity.Order;
import org.example.deliveryhub.domain.order.repository.OrderRepository;
import org.example.deliveryhub.domain.orderitem.entity.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  // order 정보 조회
  public OrderResponse getOrder(Long orderId){
    Order target = orderRepository.findById(orderId).orElse(null);

    if(target==null)
      return null;

    return OrderResponse.builder()
        .user(target.getUser())
        .restaurant(target.getRestaurant())
        .totalPrice(target.getTotalPrice())
        .status(target.getStatus())
        .orderItemList(target.getOrderItemList())
        .build();
  }

  // order 생성
  public OrderResponse createOrder(OrderRequest request){
    Order saved = orderRepository.save(Order.builder()
        .user(request.getUser())
        .restaurant(request.getRestaurant())
        .status("before accepted")
        .location("")
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .orderItemList(request.getOrderItemList())
        .totalPrice(caculateTotalPrice(request.getOrderItemList()))
        .build());

    return OrderResponse.builder()
        .user(saved.getUser())
        .restaurant(saved.getRestaurant())
        .totalPrice(saved.getTotalPrice())
        .status(saved.getStatus())
        .orderItemList(saved.getOrderItemList())
        .build();
  }

  // order 삭제
  public void deleteOrder(Long orderId){
    orderRepository.deleteById(orderId);
  }

  // order 수락/거절
  public OrderResponse updateOrderStatus(Long orderId, String select){
    Order target = orderRepository.findById(orderId).orElse(null);

    if(target==null)
        return null;

    target.setStatus(select);
    target.setUpdatedAt(LocalDateTime.now());

    Order saved = orderRepository.save(target);

    return OrderResponse.builder()
        .user(saved.getUser())
        .restaurant(saved.getRestaurant())
        .totalPrice(saved.getTotalPrice())
        .status(saved.getStatus())
        .orderItemList(saved.getOrderItemList())
        .build();
  }



  private int caculateTotalPrice(List<OrderItem> orderItemList){
    int total =0;
    for(OrderItem item: orderItemList)  total+=item.getPrice();

    return total;
  }
}
