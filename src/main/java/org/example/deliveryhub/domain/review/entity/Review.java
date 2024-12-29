package org.example.deliveryhub.domain.review.entity;

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
import org.example.deliveryhub.domain.user.entity.User;
import org.example.deliveryhub.domain.restaurant.entity.Restaurant;

@Entity(name = "review")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="review_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name="restaurant_id")
  private Restaurant restaurant;

  @Column(name="title")
  private String title;

  @Column(name="content")
  private String content;

  @Column(name="rate")
  private int rate;

}
