package com.cs5800.lab4;

import java.util.ArrayList;

public class WeightedAverage implements AverageStrategy {

    double assignmentWeight;
    double examWeight;

    WeightedAverage(double assignmentWeight, double examWeight){
        this.assignmentWeight = assignmentWeight;
        this.examWeight = examWeight;
    }

    public double calcAverage(ArrayList<Double> assignments, ArrayList<Double> exams){
        double assignAverage = calcSimpleAverage(assignments);
        double examAverage = calcSimpleAverage(exams);
        return assignAverage * assignmentWeight + examAverage * examWeight;
    }

    public static double calcSimpleAverage(ArrayList<Double> arrList){
		int n = arrList.size();
		double sum = 0.0;
		for(double element : arrList){
			sum += element;
		}
		return sum / n;
	}
}