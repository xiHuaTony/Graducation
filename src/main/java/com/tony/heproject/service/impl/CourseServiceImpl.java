package com.tony.heproject.service.impl;

import com.tony.heproject.bean.user_course;
import com.tony.heproject.bean.Course;
import com.tony.heproject.mapper.CourseMapper;
import com.tony.heproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> selectAllCourses(String teacher,String school) {
        return courseMapper.selectAllCourses(teacher,school);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseMapper.deleteCourse(id);
    }

    @Override
    public List<user_course>  uncheckList(String teacher, String school) {
        return courseMapper.uncheckList(teacher,school);
    }
}

