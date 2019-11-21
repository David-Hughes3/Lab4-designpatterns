package com.cs5800.lab4;

import java.util.ArrayList;
import java.util.Collections;
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
		this.averageStrategy = new AssignmentFortyExamSixty();
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
		return averageStrategy.calcAverage();
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

	private interface AverageStrategy {
		abstract double calcAverage();
	}

	public void setDropLowestAssign(boolean doDropLowestAssign){
		setChanged();
		notifyObservers();
		if (doDropLowestAssign)
			this.averageStrategy = new DropLowestAssign();
		else
			this.averageStrategy = new AssignmentFortyExamSixty();
	}

	private class AssignmentFortyExamSixty implements AverageStrategy {

		public double calcAverage(){
			double assignAverage = calcSimpleAverage(assignments);
			double examAverage = calcSimpleAverage(exams);
			return assignAverage * 0.40 + examAverage * 0.60;
		}
	}

	private class DropLowestAssign implements AverageStrategy {

		public double calcAverage(){
			ArrayList<Double> tempAssignments = (ArrayList) assignments.clone();
			Collections.sort(tempAssignments);
			tempAssignments.remove(0);

			double assignAverage = calcSimpleAverage(tempAssignments);
			double examAverage = calcSimpleAverage(exams);
			return assignAverage * 0.40 + examAverage * 0.60;
		}
	}

	private double calcSimpleAverage(ArrayList<Double> arrList){
		int n = arrList.size();
		double sum = 0.0;
		for(double element : arrList){
			sum += element;
		}
		return sum / n;
	}

}
