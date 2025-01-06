package org.example.deliveryhub.domain.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.restaurant.dto.RestaurantResponse;
import org.example.deliveryhub.domain.restaurant.service.RestaurantService;
import org.example.deliveryhub.global.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
