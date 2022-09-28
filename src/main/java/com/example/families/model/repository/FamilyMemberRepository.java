package com.example.families.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.families.model.entity.FamilyMember;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {
	
	@Query(value = "SELECT f FROM FamilyMember f WHERE f.family.id LIKE '%' || :family_id || '%' "
			+ "AND f.givenName LIKE '%' || :givenName || '%' "
			+ "AND f.familyName LIKE '%' || :familyName || '%' ")
	FamilyMember searchFamilyMember(@Param("family_id") Integer family_id, @Param("givenName") String givenName, @Param("familyName") String familyName);

}
