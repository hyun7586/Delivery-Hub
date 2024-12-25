package org.example.deliveryhub.domain;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orderitem")
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name="item_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name="order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name="menu_id")
  private Menu menu;

  @Column(name="quantity")
  private int quantity;

  @Column(name="price")
  private int price;


}
