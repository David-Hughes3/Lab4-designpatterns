package com.cs5800.lab4;

import java.util.*;


public class Roster {
    
    private String courseName;             
    private String courseNumber;           
    private ArrayList<Student> students;   
    
    public Roster(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        students = new ArrayList<Student>();
    }
    
    public String getCourseName() {
        return courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }
    
    public void addStudent (Student student) {
        students.add(student);
    }

	public AvgDispenser getDispenser() {
        //anonymous inner class that returns the implementation of the iterator interface
		return new AvgDispenser(){
            ArrayList<Student> tempStudents = (ArrayList<Student>)students.clone();

            public double getNextAvg(){
                double nextAvg = tempStudents.get(0).getAverage();
                tempStudents.remove(0);
                return nextAvg;
            }
            public boolean hasNextAvg(){
                return tempStudents.size() == 0;
            }
        };
	}
    
}
