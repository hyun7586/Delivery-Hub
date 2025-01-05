package org.example.deliveryhub.domain.menu.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.dto.MenuRequest;
import org.example.deliveryhub.domain.menu.dto.MenuResponse;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.menu.service.MenuService;
import org.example.deliveryhub.global.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {

  private final MenuService menuService;

  // 단일 메뉴 정보 조회
  @GetMapping("/{menu_id}")
  public ResponseEntity<ResponseApi<MenuResponse>> getMenu(
      @PathVariable(name = "menu_id") Long menuId
  ){
    MenuResponse response = menuService.findById(menuId);
    ResponseApi<MenuResponse> result = ResponseApi.<MenuResponse>builder()
        .statusCode("200")
        .message("successfully found the data")
        .data(response)
        .build();

    return ResponseEntity.status(HttpStatus.OK)
        .body(result);
  }

  // 메뉴 리스트 조회
  @GetMapping("/all")
  public ResponseEntity<ResponseApi<List<MenuResponse>>> getMenuList(){
    List<MenuResponse> responseData = menuService.findAll();

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<List<MenuResponse>>builder()
            .statusCode("200")
            .message("successfully found the list")
            .data(responseData)
            .build());
  }

  // 메뉴 추가
  @PostMapping("/")
  public ResponseEntity<ResponseApi<MenuResponse>> createMenu(
      @RequestBody MenuRequest request
  ){
    MenuResponse responseData = menuService.createMenu(request);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<MenuResponse>builder()
            .statusCode("200")
            .message("the data is created")
            .data(responseData)
            .build());
  }


  // 특정 메뉴 정보 수정
  @PatchMapping("/{menu_id}")
  public ResponseEntity<ResponseApi<MenuResponse>> updateMenu(
      @PathVariable(name="menu_id") Long menuId,
      @RequestBody MenuRequest menuRequest
  ){
    MenuResponse result = menuService.updateMenu(menuId, menuRequest);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.<MenuResponse>builder()
            .statusCode("200")
            .message("successfully modified")
            .data(result)
            .build());
  }

  // 특정 메뉴 삭제
  @DeleteMapping("/{menu_id}")
  public ResponseEntity<ResponseApi<?>> deleteMenu(
      @PathVariable(name="menu_id") Long menuId
  ){
    if(menuService.findById(menuId)==null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(ResponseApi.builder()
              .statusCode("404")
              .message("the data is not found")
              .data("").build());
    }

    menuService.deleteMenu(menuId);

    return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseApi.builder()
            .statusCode("200")
            .message("the deletion is completed")
            .data("")
            .build());
  }




}
