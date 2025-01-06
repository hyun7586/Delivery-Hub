package org.example.deliveryhub.domain.restaurant.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.dto.MenuResponse;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantResponse;
import org.example.deliveryhub.domain.restaurant.service.RestaurantService;
import org.example.deliveryhub.global.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

  private final RestaurantService restaurantService;

  // 식당 정보 조회
  @GetMapping("/{restaurant_id}")
  public ResponseEntity<ResponseApi<?>> getRestaurant(
      @PathVariable(name="restaurant_id") Long restaurantId
  ){
    RestaurantResponse responseData = restaurantService.findById(restaurantId);

    if(responseData==null)
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(ResponseApi.builder()
              .statusCode("404")
              .message("the data is not found")
              .data(null)
              .build());

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<RestaurantResponse>builder()
            .statusCode("200")
            .message("the data is found")
            .data(responseData)
            .build());
  }

  // 식당 메뉴 리스트 조회
  @GetMapping("/{restaurant_id}/menus")
  public ResponseEntity<ResponseApi<List<MenuResponse>>> getMenuList(
      @PathVariable(name="restaurant_id") Long restaurantId
  ){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<List<MenuResponse>>builder()
            .statusCode("200")
            .message("the data is found")
            .data(restaurantService.findAllMenu(restaurantId))
            .build());
  }

  // 식당 목록 조회
  @GetMapping("/all")
  public ResponseEntity<ResponseApi<List<RestaurantResponse>>> getRestaurantList(){
    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<List<RestaurantResponse>>builder()
            .statusCode("200")
            .message("the data is found")
            .data(restaurantService.findAll())
            .build());
  }

}
