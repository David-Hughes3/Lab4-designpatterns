package com.cs5800.lab4;

import java.util.Observable;
import java.util.Observer;

public class GradeTracker implements Observer {
    private char letterGrade;

    public GradeTracker(Student student){
        student.addObserver(this);
        letterGrade = student.getLetterGrade();
    }

    public char getLetterGrade(){
        return letterGrade;
    }

    public void update(Observable obj, Object arg){
        Student student = (Student)obj;
        if(letterGrade != student.getLetterGrade()){
            letterGrade = student.getLetterGrade();
        }
    }
}