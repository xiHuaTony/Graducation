package com.tony.heproject.service.impl;

import com.tony.heproject.bean.Course;
import com.tony.heproject.mapper.ExamineMapper;
import com.tony.heproject.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Autowired
    private ExamineMapper examineMapper;

    @Override
    public List<Course> selectExamineList(String school) {
        return examineMapper.selectExamineList(school);
    }
}
