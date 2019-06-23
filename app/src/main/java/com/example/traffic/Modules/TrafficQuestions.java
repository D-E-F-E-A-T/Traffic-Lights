package com.example.traffic.Modules;

import java.util.ArrayList;
import java.util.List;

public class TrafficQuestions {

    String Image;
    String answer1;
    String answer2;
    String answer3;
    String RightAnswer;

    List<String>answers=new ArrayList<>();
    public TrafficQuestions(String image, String answer1, String answer2, String answer3, String rightAnswer) {
        Image = image;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        RightAnswer = rightAnswer;

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getRightAnswer() {
        return RightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        RightAnswer = rightAnswer;
    }
}
