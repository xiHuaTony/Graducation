package com.tony.heproject.service.impl;

import com.tony.heproject.bean.School;
import com.tony.heproject.mapper.SchoolMapper;
import com.tony.heproject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;


    @Override
    public List<School> selectAllSchools() {
        return schoolMapper.selectAllSchools();
    }

    @Override
    public void addSchool(School school) {
        schoolMapper.addSchool(school);
    }

    @Override
    public void deleteSchool(int id) {
        schoolMapper.deleteSchool(id);
    }
}
