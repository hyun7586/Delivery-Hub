package org.example.deliveryhub.domain.menu.service;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.deliveryhub.domain.menu.dto.MenuRequest;
import org.example.deliveryhub.domain.menu.dto.MenuResponse;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

  private final MenuRepository menuRepository;

  // 메뉴 조회
  public MenuResponse findById(Long id){

    Menu result = menuRepository.findById(id).orElse(null);

    if(result==null){
      // throw Exception으로 변경할 예정
      return null;
    }

    return MenuResponse.builder()
        .name(result.getName())
        .description(result.getDescription())
        .price(result.getPrice())
        .build();
  }

  // 메뉴 리스트 조회
  public List<MenuResponse> findAll(){

    return menuRepository.findAll().stream()
        .map(each -> MenuResponse.builder()
            .name(each.getName())
            .description(each.getDescription())
            .price(each.getPrice())
            .build())
        .toList();
  }

  // 메뉴 추가
  public MenuResponse createMenu(MenuRequest request){
    Menu saved = menuRepository.save(Menu.builder()
        .name(request.getName())
        .description(request.getDescription())
        .price(request.getPrice())
        .restaurant(request.getRestaurant())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build());

    return MenuResponse.builder()
        .name(saved.getName())
        .description(saved.getDescription())
        .price(saved.getPrice())
        .build();
  }

  // 특정 메뉴 정보 수정
  public MenuResponse updateMenu(Long menuId, MenuRequest request){

    Menu target = menuRepository.findById(menuId).orElse(null);

    if(target==null){
      return null;
    }

    // request 객체에서 null이 아닌 field에 대해서만 수정
    if(request.getRestaurant()!=null) target.setRestaurant(request.getRestaurant());
    if(request.getName()!=null) target.setName(request.getName());
    if(request.getDescription()!=null)  target.setDescription(request.getDescription());
    if(request.getPrice()!=null)  target.setPrice(request.getPrice());

    Menu result = menuRepository.save(target);

    return MenuResponse.builder()
        .name(result.getName())
        .description(result.getDescription())
        .price(result.getPrice())
        .build();
  }

  // 특정 메뉴 삭제
  public void deleteMenu(Long menuId){
    menuRepository.deleteById(menuId);
  }

}
