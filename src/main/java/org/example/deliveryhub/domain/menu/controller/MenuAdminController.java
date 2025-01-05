package org.example.deliveryhub.domain.menu.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.menu.repository.MenuRepository;
import org.example.deliveryhub.domain.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/menu")
public class MenuAdminController {

  private final MenuService menuService;
  private final MenuRepository menuRepository;

  // 특정 메뉴 조회 for admin
  @GetMapping("/{menu_id}")
  public ResponseEntity<Optional<Menu>> adminGetMenu(
      @PathVariable(name="menu_id") Long menuId
  ){
    return ResponseEntity.status(HttpStatus.OK)
        .body(menuRepository.findById(menuId));
  }

  // 메뉴 리스트 조회 for admin
  @GetMapping("/all")
  public ResponseEntity<List<Menu>> adminGetMenuList(){
    return ResponseEntity.status(HttpStatus.OK)
        .body(menuRepository.findAll());
  }


}
