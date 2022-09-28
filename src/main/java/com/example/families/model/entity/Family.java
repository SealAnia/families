package com.example.families.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "family")
public class Family {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer familyid;
	@Column(name = "family_name")
	private String familyName;
	@Column(name = "number_of_infants")
	private Integer numberOfInfants = 0;
	@Column(name = "number_of_children")
	private Integer numberOfChildren = 0;
	@Column(name = "number_of_adults")
	private Integer numberOfAdults = 0;
	
	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	private List<FamilyMember> familyMembers;
	
	public Integer getFamilyid() {
		return familyid;
	}
	public void setFamilyid(Integer familyid) {
		this.familyid = familyid;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public Integer getNumberOfInfants() {
		return numberOfInfants;
	}
	public void setNumberOfInfants(Integer numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}
	
	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	
	public Integer getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(Integer numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	
	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
}
