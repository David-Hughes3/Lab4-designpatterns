package com.cs5800.lab4;

import java.util.ArrayList;
import java.util.Observable;


public class Student extends Observable{

    private String name;                    
    private ArrayList<Double> assignments;  
	private ArrayList<Double> exams;
	private AverageStrategy averageStrategy;        
    
	public Student(String name) {
		this.name = name;
        this.assignments = new ArrayList<Double>();
		this.exams = new ArrayList<Double>();
		this.averageStrategy = new WeightedAverage(0.40, 0.60);
	}


	public String getName() {
		return name;
	}

	public void addAssignmentScore (double assignmentScore) {
		assignments.add(assignmentScore);
		setChanged();
 		notifyObservers();
	}

	public void addExamScore (double examScore) {
		exams.add(examScore);
		setChanged();
 		notifyObservers();
	}

	public double getAverage() {
		return averageStrategy.calcAverage(this.assignments, this.exams);
	}

	public char getLetterGrade(){
		double grade = getAverage();
		if(grade >= 90.0) {
			return 'A';
		}
		else if(grade >= 80.0){
			return 'B';
		}
		else if(grade >= 70.0){
			return 'C';
		}
		else if(grade >= 60.0){
			return 'D';
		}
		else {
			return 'F';
		}
	}

	public void setDropLowestAssign(boolean doDropLowestAssign){
		setChanged();
		notifyObservers();
		if (doDropLowestAssign)
			this.averageStrategy = new DropLowestAssignAverage(0.40, 0.60);
		else
			this.averageStrategy = new WeightedAverage(0.40, 0.60);
	}







}
