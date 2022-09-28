package com.example.families.controller;

import java.util.List;
import com.example.families.service.impl.FamilyMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.families.model.entity.FamilyMember;

@RestController
@RequestMapping("/family_members")
public class FamilyMemberController {
	
	private final FamilyMemberServiceImpl familyMemberService;
	
	@Autowired
	public FamilyMemberController(FamilyMemberServiceImpl familyMemberService) {
		this.familyMemberService = familyMemberService;
	}
	
	@PostMapping("/")
	public void addPerson(@RequestBody FamilyMember familyMember) {
		familyMemberService.createOrUpdate(familyMember);
	}
	
	@GetMapping(value = "")
	public List<FamilyMember> readAll() {
		return familyMemberService.getAll();
	}
	
	@GetMapping("/{id}")
	public FamilyMember getFamilyMember(@PathVariable Integer id) {
		return familyMemberService.readById(id);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FamilyMember> update(@PathVariable int id,@RequestBody FamilyMember familyMember) {
		FamilyMember updatedFamilyMember = familyMemberService.readById(id);
		updatedFamilyMember.setGivenName(familyMember.getGivenName());
		updatedFamilyMember.setFamilyName(familyMember.getFamilyName());
		updatedFamilyMember.setAge(familyMember.getAge());
		updatedFamilyMember.setFamily(familyMember.getFamily());
        familyMemberService.createOrUpdate(updatedFamilyMember);
        return ResponseEntity.ok(updatedFamilyMember);
    }
	
	@RequestMapping(value = "/{id}", produces = "application/json", method=RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") int id) {
		familyMemberService.delete(id);
	}
	
}
