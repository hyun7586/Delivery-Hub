package org.example.deliveryhub.domain.orderitem.repository;

import org.example.deliveryhub.domain.orderitem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
