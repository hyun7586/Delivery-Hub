package org.example.deliveryhub.domain.menu.dto;

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

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MenuRequest {

  private Restaurant restaurant;
  private String name;
  private String description;
  private Integer price;

}
