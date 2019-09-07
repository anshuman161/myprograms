package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.StudentDetails;

public interface StudentDao extends CrudRepository<StudentDetails, Integer>{

	

}
