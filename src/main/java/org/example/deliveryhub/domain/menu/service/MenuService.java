package org.example.deliveryhub.domain.menu.service;

import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final MenuRepository menuRepository;

  // 메뉴 조회
  Menu getMenuById(Long id){
    return menuRepository.findById(id).orElse(null);
  }

  // Restaurant별 Menu List 반환은 어디서 함?
  // Restaurant에 List<Menu> field가 있으니 RestaurantService에 구현해야 하나?
}
