package com.example.families.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.families.model.entity.FamilyMember;
import com.example.families.model.repository.FamilyMemberRepository;
import com.example.families.service.FamilyMemberService;

@Service
@Transactional
public class FamilyMemberServiceImpl implements FamilyMemberService {
	
	private final FamilyMemberRepository familyMemberRepository;
	
	@Autowired
	public FamilyMemberServiceImpl(FamilyMemberRepository familyMemberRepository) {
		this.familyMemberRepository = familyMemberRepository;
	}

	@Override
	public void createOrUpdate(FamilyMember familyMember) {
		familyMemberRepository.save(familyMember);
	}

	@Override
	public List<FamilyMember> getAll() {
		return familyMemberRepository.findAll();
	}

	@Override
	public FamilyMember readById(int id) {
		return familyMemberRepository.findById(id).get();
	}
	
	@Override
	public void delete(int id) {
		familyMemberRepository.deleteById(id);
	}
	
	@Override
	public FamilyMember searchFamilyMember(Integer family_id, String givenName, String familyName) {
		return familyMemberRepository.searchFamilyMember(family_id, givenName, familyName);
	}
	
}
