package org.example.deliveryhub.domain.menu.repository;

import org.example.deliveryhub.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
