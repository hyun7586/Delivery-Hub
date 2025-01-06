package org.example.deliveryhub.domain.restaurant.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.dto.MenuResponse;
import org.example.deliveryhub.domain.menu.repository.MenuRepository;
import org.example.deliveryhub.domain.menu.service.MenuService;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantResponse;
import org.example.deliveryhub.domain.restaurant.entity.Restaurant;
import org.example.deliveryhub.domain.restaurant.mapper.RestaurantMapper;
import org.example.deliveryhub.domain.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final MenuRepository menuRepository;
  private final RestaurantMapper restaurantMapper;

  // 식당 정보 조회
  public RestaurantResponse findById(Long restaurantId){
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    if(restaurant==null)  return null;

    return restaurantMapper.toResponse(restaurant);
  }

  // 식당 메뉴 리스트 조회
  public List<MenuResponse> findAll(Long restaurantId){
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    // 이후 throw exception으로 처리
    if(restaurant==null)  return null;

    return restaurant.getMenuList().stream()
        .map(each -> MenuResponse.builder()
            .name(each.getName())
            .description(each.getDescription())
            .price(each.getPrice())
            .build())
        .toList();
  }

}
