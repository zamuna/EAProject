package org.mum.edu.ea.repository;

import org.mum.edu.ea.domain.Category;
import org.mum.edu.ea.domain.PositionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionCategoryRepository extends JpaRepository<PositionCategory, Long> {
    
	PositionCategory findByType(Category type);
}
