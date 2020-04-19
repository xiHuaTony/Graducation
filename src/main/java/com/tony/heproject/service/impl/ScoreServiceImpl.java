package com.tony.heproject.service.impl;


import com.tony.heproject.bean.score_look;
import com.tony.heproject.bean.user_course;
import com.tony.heproject.mapper.ScoreMapper;
import com.tony.heproject.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<user_course> getScores(String teacher) {
        return scoreMapper.getScores(teacher);
    }

    @Override
    public List<user_course> setScores(String teacher) {
        return scoreMapper.setScores(teacher);
    }

    @Override
    public List<score_look> scoresLook(String teacher){
        return scoreMapper.scoresLook(teacher);
    }

    @Override
    public void scoreToSet(Integer account,Integer courseNum,Integer score)
    {
        scoreMapper.scoreToSet(account,courseNum,score);
    }
}
