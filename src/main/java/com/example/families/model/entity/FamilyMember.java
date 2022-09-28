package com.example.families.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "family_member")
public class FamilyMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "given_name")
	private String givenName;
	@Column(name = "family_name")
	private String familyName;
	@Column(name = "age")
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name = "family_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Family family;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}

}
