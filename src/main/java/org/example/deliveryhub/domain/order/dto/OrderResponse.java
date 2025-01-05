package org.example.deliveryhub.domain.order.dto;

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
public class OrderResponse {

  private User user;
  private Restaurant restaurant;
  private Integer totalPrice;
  private String status;
  private List<OrderItem> orderItemList;

}