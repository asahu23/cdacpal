package com.cdacpal.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cdacpal.Entity.Media;


public interface MediaRepository extends CrudRepository<Media, Long>{

	List<Media> findAll();
	//public Media findByCourseId(Long id);
	List<Media> findMediaByCourseid(Long id);
}
