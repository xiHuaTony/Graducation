package com.tony.heproject.service;

import com.tony.heproject.bean.user_course;
import com.tony.heproject.bean.Course;

import java.util.List;

public interface CourseService {
    /**
     * 查询所有课程
     * @return
     */
    List<Course> selectAllCourses(String teacher,String school);

    /**
     * 增加课程
     * @param course
     * @return
     */
    void addCourse(Course course);

    /**
     * 删除课程
     * @param id
     * @return
     */
    void deleteCourse(int id);

    /**
     * 试剂课程
     * @return
     */
    List<user_course>   uncheckList(String teacher, String school);

}
