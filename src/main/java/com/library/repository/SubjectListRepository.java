package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.SubjectList;

@Repository
public interface SubjectListRepository extends CrudRepository<SubjectList, String>{
	

}
