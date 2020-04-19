package com.tony.heproject.service;

import com.tony.heproject.bean.Course;
import com.tony.heproject.bean.user_course;

import java.util.List;

public interface ExamineService {
    /**
     * 查询待处理课程
     * @return
     */
    List<Course> selectExamineList(String school);





}
