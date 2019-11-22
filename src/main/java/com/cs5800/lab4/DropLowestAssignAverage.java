package com.cs5800.lab4;

import java.util.ArrayList;
import java.util.Collections;

public class DropLowestAssignAverage extends WeightedAverage implements AverageStrategy {

    DropLowestAssignAverage(double assignmentWeight, double examWeight){
        super(assignmentWeight, examWeight);
    }

    public double calcAverage(ArrayList<Double> assignments, ArrayList<Double> exams){
        ArrayList<Double> removeLowest = (ArrayList) assignments.clone();
        Collections.sort(removeLowest);
        removeLowest.remove(0);

        return super.calcAverage(removeLowest, exams);
    }
}