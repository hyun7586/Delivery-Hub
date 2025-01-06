package org.example.deliveryhub.domain.restaurant.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantRequest;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantResponse;
import org.example.deliveryhub.domain.restaurant.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

  // Restaurant entity -> RestaurantResponse
  public RestaurantResponse toResponse(Restaurant entity){
    return RestaurantResponse.builder()
        .user(entity.getUser())
        .name(entity.getName())
        .location(entity.getLocation())
        .orderList(entity.getOrderList())
        .menuList(entity.getMenuList())
        .build();
  }

  // RestaurantRequest -> Restaurant entity
  public Restaurant toEntity(RestaurantRequest request){
    return Restaurant.builder()
        .user(request.getUser())
        .name(request.getName())
        .location(request.getLocation())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .orderList(null)
        .menuList(request.getMenuList())
        .build();
  }
}
