package org.example.deliveryhub.domain.order.repository;

import org.example.deliveryhub.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
