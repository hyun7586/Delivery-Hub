package org.example.deliveryhub.domain.order.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.deliveryhub.domain.orderitem.entity.OrderItem;
import org.example.deliveryhub.domain.restaurant.entity.Restaurant;
import org.example.deliveryhub.domain.user.entity.User;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderRequest {

  // request 측에서는 orderItemList만 제시 -> 비즈니스 로직에서 해당 주문에 대한 totalPrice 구해서 DB에 저장

  private User user;
  private Restaurant restaurant;
  private List<OrderItem> orderItemList;

}
