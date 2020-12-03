package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImp implements CourseService {
	
	//List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImp() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Course", "This course contains basic of Java"));
//		list.add(new Course(199, "Spring Boot Course", "Creating Rest API using Spring Boot"));
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});

		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = this.list.stream().filter(e -> e.getId() != courseId).collect(Collectors.toList());	
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	}

}
