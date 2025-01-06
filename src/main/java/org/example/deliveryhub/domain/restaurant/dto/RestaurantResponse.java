package org.example.deliveryhub.domain.restaurant.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.deliveryhub.domain.menu.entity.Menu;
import org.example.deliveryhub.domain.order.entity.Order;
import org.example.deliveryhub.domain.user.entity.User;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RestaurantResponse {

  private User user;
  private String name;
  private String location;

  private List<Order> orderList;
  private List<Menu> menuList;

}
