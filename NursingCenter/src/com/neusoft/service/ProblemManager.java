package com.neusoft.service;

import com.neusoft.dao.AbstractProblem;
import com.neusoft.entity.Patient;
import com.neusoft.entity.Problem;
import com.neusoft.util.FileOperator;
import java.util.List;

public class ProblemManager implements AbstractProblem {
    private List<Problem> problems;
    private long problemId = 1;
    private static ProblemManager singletonInstance;

    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }


    private ProblemManager() {
        problems = FileOperator.loadData("Problems.json", Patient.class);
    }

    //单例模式
    public static ProblemManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new ProblemManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addProblem(Problem problem) {
        problems.add(problem);
        FileOperator.writeData(problem, "Problems.json");
        return true;
    }
    //删
    public void removeProblem(Problem problem) {
        problems.remove(problem);
        FileOperator.writeData(problems, "Problems.json");
    }

    public List<Problem> getProblems() {
        return problems;
    }
}
