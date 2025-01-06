package org.example.deliveryhub.domain.restaurant.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.dto.MenuResponse;
import org.example.deliveryhub.domain.menu.repository.MenuRepository;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantRequest;
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
  public RestaurantResponse findById(Long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    if (restaurant == null) {
      return null;
    }

    return restaurantMapper.toResponse(restaurant);
  }

  // 식당 메뉴 리스트 조회
  public List<MenuResponse> findAllMenu(Long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    // 이후 throw exception으로 처리
    if (restaurant == null) {
      return null;
    }

    return restaurant.getMenuList().stream()
        .map(each -> MenuResponse.builder()
            .name(each.getName())
            .description(each.getDescription())
            .price(each.getPrice())
            .build())
        .toList();
  }

  // 식당 리스트 조회
  public List<RestaurantResponse> findAll() {
    return restaurantRepository.findAll().stream()
        .map(restaurantMapper::toResponse)
        .toList();
  }


  // 특정 식당 메뉴 등록
  public RestaurantResponse addMenu(Long restaurantId ,RestaurantRequest request) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

    // 이후 throw exception으로 처리할 예정
    if(restaurant==null)  return null;
    if(request.getMenuList()==null) return null;

    restaurant.getMenuList().addAll(request.getMenuList());

    return restaurantMapper.toResponse(restaurantRepository.save(restaurant));
  }
}
