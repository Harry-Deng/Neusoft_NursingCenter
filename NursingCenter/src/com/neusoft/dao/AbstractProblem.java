package com.neusoft.dao;

import com.neusoft.entity.Problem;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:48
 * @Description 抽象问题接口类
 * @Since version-1.0
 */
public interface AbstractProblem {
    boolean addProblem(Problem problem);
    void removeProblem(Problem problem);
    List<Problem> getProblems();
}
