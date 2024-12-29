package org.example.deliveryhub.domain.user.repository;

import org.example.deliveryhub.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
