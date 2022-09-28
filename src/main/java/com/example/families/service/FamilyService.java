package com.example.families.service;

import com.example.families.model.entity.Family;

public interface FamilyService extends DefaultService<Family> {
	
	Integer countInfants(Family family);
	Integer countChildren(Family family);
	Integer countAdults(Family family);
	
}
