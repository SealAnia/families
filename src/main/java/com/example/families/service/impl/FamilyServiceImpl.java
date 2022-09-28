package com.example.families.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.families.model.entity.Family;
import com.example.families.model.entity.FamilyMember;
import com.example.families.model.repository.FamilyRepository;
import com.example.families.service.FamilyService;

@Service
@Transactional
public class FamilyServiceImpl implements FamilyService {
	
	private final FamilyRepository familyRepository;

	@Autowired
	public FamilyServiceImpl(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}

	@Override
	public void createOrUpdate(Family family) {
		familyRepository.save(family);
	}

	@Override
	public List<Family> getAll() {
		return familyRepository.findAll();
	}

	@Override
	public Family readById(int id) {
		return familyRepository.findById(id).get();
	}
	
	@Override
	public void delete(int id) {
		familyRepository.deleteById(id);
	}
	
	@Override
	public Integer countInfants(Family family) {
		int infants = 0;
		for(FamilyMember fm : family.getFamilyMembers()) {
			if(fm.getAge() == 0 && fm.getAge() < 4) {
				infants++;
			}
		}	
		return infants;
	}
	
	@Override
	public Integer countChildren(Family family) {
		int children = 0;
		for(FamilyMember fm : family.getFamilyMembers()) {
			if(fm.getAge() >= 4 && fm.getAge() < 16) {
				children++;
			}
		}	
		return children;
	}
	
	@Override
	public Integer countAdults(Family family) {
		int adults = 0;
		for(FamilyMember fm : family.getFamilyMembers()) {
			if(fm.getAge() >= 16) {
				adults++;
			}
		}	
		return adults;
	}
	
	public boolean validateFamilyData(Family family, Integer numberOfInfants, Integer numberOfChildren, Integer numberOfAdults) {
		if(numberOfInfants == family.getNumberOfInfants() && numberOfChildren == family.getNumberOfChildren() 
				&& numberOfAdults == family.getNumberOfAdults()) {
			return true;
		}
		else {
			return false;
		}
	}

}
