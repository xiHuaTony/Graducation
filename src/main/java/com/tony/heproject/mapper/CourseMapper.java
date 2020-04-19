package com.tony.heproject.mapper;

import com.tony.heproject.bean.user_course;
import com.tony.heproject.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CourseMapper {
    /**
     * 查询已审批课程
     * @return
     */
    List<Course> selectAllCourses(String teacher,String school);

    /**
     * 增加课程
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 删除课程
     * @param id
     * @return
     */
    int deleteCourse(int id);

    /**
     * 查询未审批课程
     *  @return
     */

    List<user_course> uncheckList(String teacher, String school);

}
