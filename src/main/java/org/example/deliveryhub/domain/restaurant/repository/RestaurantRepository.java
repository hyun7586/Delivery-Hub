package org.example.deliveryhub.domain.restaurant.repository;

import org.example.deliveryhub.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
