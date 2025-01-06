package org.example.deliveryhub.domain.restaurant.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantResponse;
import org.example.deliveryhub.domain.restaurant.entity.Restaurant;
import org.example.deliveryhub.domain.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  // 식당 정보 조회
  public RestaurantResponse findById(Long restaurantId){
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    if(restaurant==null)  return null;

    return RestaurantResponse.builder()
        .user(restaurant.getUser())
        .name(restaurant.getName())
        .location(restaurant.getLocation())
        .orderList(restaurant.getOrderList())
        .menuList(restaurant.getMenuList())
        .build();
  }

}
