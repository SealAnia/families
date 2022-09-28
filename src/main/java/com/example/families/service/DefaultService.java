package com.example.families.service;

import java.util.List;

public interface DefaultService<T> {
	
	void createOrUpdate(T t);
	List<T> getAll();
	T readById(int id);
	void delete(int id);

}
