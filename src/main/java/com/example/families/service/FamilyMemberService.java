package com.example.families.service;

import com.example.families.model.entity.FamilyMember;

public interface FamilyMemberService extends DefaultService<FamilyMember> {
	
	FamilyMember searchFamilyMember(Integer family_id, String givenName, String familyName);
	
}
