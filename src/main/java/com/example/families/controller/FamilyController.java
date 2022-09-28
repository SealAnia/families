package com.example.families.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.families.model.entity.Family;
import com.example.families.model.entity.FamilyMember;
import com.example.families.service.impl.FamilyMemberServiceImpl;
import com.example.families.service.impl.FamilyServiceImpl;

@RestController
@RequestMapping("/families")
public class FamilyController {

private final FamilyServiceImpl familyService;

private final FamilyMemberServiceImpl familyMemberService;
	
	@Autowired
	public FamilyController(FamilyServiceImpl familyService, FamilyMemberServiceImpl familyMemberService) {
		this.familyService = familyService;
		this.familyMemberService = familyMemberService;
	}
	
	@PostMapping("/")
    public void addFamily(@RequestBody Family family) {
		familyService.createOrUpdate(family);
	}
	
	@GetMapping(value = "")
	public List<Family> readAll() {
		return familyService.getAll();
	}
	
	@GetMapping("/{id}")
	public Family getFamily(@PathVariable Integer id) {
		return familyService.readById(id);
	}

	@GetMapping(value = "/{family_id}/{givenName}_{familyName}")
	public FamilyMember searchFamilyMember(@PathVariable Integer family_id, @PathVariable String givenName, @PathVariable String familyName) {
		return familyMemberService.searchFamilyMember(family_id, givenName, familyName);
	}
	
	@GetMapping(value = "/{family_id}/{numberOfInfants}_{numberOfChildren}_{numberOfAdults}")
	public boolean validateFamilyData(@PathVariable Integer family_id, @PathVariable Integer numberOfInfants, 
			@PathVariable Integer numberOfChildren, @PathVariable Integer numberOfAdults, 
			Model model) {
		Family family = familyService.readById(family_id);
		return familyService.validateFamilyData(family, numberOfInfants, numberOfChildren, numberOfAdults);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Family> update(@PathVariable int id,@RequestBody Family family) {
		Family updatedFamily = familyService.readById(id);
		updatedFamily.setFamilyName(family.getFamilyName());
		updatedFamily.setNumberOfInfants(familyService.countInfants(updatedFamily));
		updatedFamily.setNumberOfChildren(familyService.countChildren(updatedFamily));
		updatedFamily.setNumberOfAdults(familyService.countAdults(updatedFamily));
        familyService.createOrUpdate(updatedFamily);
        return ResponseEntity.ok(updatedFamily);
    }
	
	@RequestMapping(value = "/{id}", produces = "application/json", method=RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") int id) {
		familyService.delete(id);
	}
	
}
