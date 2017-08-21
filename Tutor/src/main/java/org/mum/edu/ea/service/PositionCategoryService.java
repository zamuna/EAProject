package org.mum.edu.ea.service;

import org.mum.edu.ea.domain.PositionCategory;

import java.util.List;

public interface PositionCategoryService {
    
	public PositionCategory FindByType(String type);
	public List<PositionCategory> findAll();
}
