package org.example.deliveryhub.domain.review.repository;

import org.example.deliveryhub.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
