package org.mum.edu.ea.serviceimpl;


import org.mum.edu.ea.domain.Category;
import org.mum.edu.ea.domain.PositionCategory;
import org.mum.edu.ea.repository.PositionCategoryRepository;
import org.mum.edu.ea.service.PositionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionCategoryImpl implements PositionCategoryService{
	
    @Autowired
	private PositionCategoryRepository prepository;
	
	@Override
	public PositionCategory FindByType(String type) {
	     Category c = Category.valueOf(type);
		 
		
		return prepository.findByType(c);
	}

	@Override
	public List<PositionCategory> findAll() {
		return prepository.findAll();
	}

}
