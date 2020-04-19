package com.tony.heproject.service;

import com.tony.heproject.bean.School;
import com.tony.heproject.bean.score_look;
import com.tony.heproject.bean.user_course;

import java.util.List;


public interface ScoreService {
    /**
     * 查询有成绩的学生
     * @param teacher
     * @return
     */
    List<user_course> getScores(String teacher);


    /**
     * 查询无成绩的学生
     * @return
     */
    List<user_course> setScores(String teacher);

    /**
     * 分数统计
     * @return
     */
    List<score_look> scoresLook(String teacher);

    /**
     * 分数操作
     * @return
     */
    void scoreToSet(Integer account,Integer courseNum,Integer score);


}
