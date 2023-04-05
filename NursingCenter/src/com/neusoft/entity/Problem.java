package com.neusoft.entity;

import com.neusoft.service.ProblemManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of class
 * @Since version-1.0
 */
public class Problem implements Serializable {
    public final static String[] TYPES = {"A", "B"};
    private String description = "";
    private int ans = 0;
    private ArrayList<String> choice = new ArrayList<String>(Arrays.asList("", "", ""));
    private long id = 0;
    private String type = Problem.TYPES[0];
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getType() {
        return type;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [type]
 * @Return void
 * @Since version-1.0
 */
    public void setType(String type) {
        this.type = type;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return long
 * @Since version-1.0
 */
    public long getId() {
        return id;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [id]
 * @Return void
 * @Since version-1.0
 */
    public void setId(long id) {
        this.id = id;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getDescription() {
        return description;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [description]
 * @Return void
 * @Since version-1.0
 */
    public void setDescription(String description) {
        this.description = description;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return int
 * @Since version-1.0
 */
    public int getAns() {
        return ans;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [ans]
 * @Return void
 * @Since version-1.0
 */
    public void setAns(int ans) {
        this.ans = ans;
    }
    /*
     * @Author DengYimo
     * @Date  4:42
     * @Description This is description of method
     * @Param []
     * @Return java.util.ArrayList<java.lang.String>
     * @Since version-1.0
     */
    public ArrayList<String> getChoice() {
        return choice;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [choice]
 * @Return void
 * @Since version-1.0
 */
    public void setChoice(ArrayList<String> choice) {
        this.choice = choice;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Problem
 * @Since version-1.0
 */
    public static Problem newProblem() {
        Problem problem = new Problem();
        problem.id = ProblemManager.getInstance().getProblemId();
        System.out.println(problem.id);
        ProblemManager.getInstance().setProblemId(problem.id + 1);
        return problem;
    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param []
 * @Return 
 * @Since version-1.0
 */
    public Problem() {

    }
/*
 * @Author DengYimo
 * @Date  4:42
 * @Description This is description of method
 * @Param [description, ans, choice, type]
 * @Return 
 * @Since version-1.0
 */
    public Problem(String description, int ans, ArrayList<String> choice, String type) {
        this.description = description;
        this.ans = ans;
        while (choice.size() < 3)
            choice.add("");
        while (choice.size() > 3) choice.remove(3);
        this.choice = choice;
        this.type = type;
        this.id = ProblemManager.getInstance().getProblemId();
        ProblemManager.getInstance().setProblemId(id + 1);
    }

}

