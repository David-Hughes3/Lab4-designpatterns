package com.cs5800.lab4;

import java.util.ArrayList;

public interface AverageStrategy {
    abstract double calcAverage(ArrayList<Double> assignments, ArrayList<Double> exams);
}