package com.tony.heproject.mapper;

import com.tony.heproject.bean.Course;
import com.tony.heproject.bean.user_course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExamineMapper {
    /**
     * 查询待处理课程
     */
    List<Course> selectExamineList(String school);

}
