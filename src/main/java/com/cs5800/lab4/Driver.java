package com.cs5800.lab4;

import java.text.DecimalFormat;

public class Driver {
    
	public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.0");

        Student student = new Student("Skip Bayless");
        student.addAssignmentScore(93.5);
        student.addAssignmentScore(92.1);
        student.addAssignmentScore(85.0);
        student.addExamScore(96);
        student.addExamScore(89);

        System.out.println("\nQuestion 1 Verification: ");
        //algorithm A:
        System.out.println(student.getName() + " ~ grade: " + df.format(student.getAverage()));
        // switch to algorithm B:
        student.setDropLowestAssign(true);
        System.out.println(student.getName() + " ~ grade: " + df.format(student.getAverage()));
        // switch back to algorithm A:
        student.setDropLowestAssign(false);
        System.out.println(student.getName() + " ~ grade: " + df.format(student.getAverage()));
        


        System.out.println("\nQuestion 2 Verification: ");
        //test the GradeTracker
        GradeTracker gt = new GradeTracker(student);
        System.out.println( student.getName() + " ~ letter grade: " + gt.getLetterGrade());
        double newScore = 10;
        student.addExamScore(newScore);
        System.out.println("Added an exam score: " + newScore );
        System.out.println(student.getName() + " ~ letter grade: " + gt.getLetterGrade());
        


        System.out.println("\nQuestion 3 Verification: ");
        //add a new student
        Student student2 = new Student("Shannon Sharpe");
        student2.addAssignmentScore(86.2);
        student2.addAssignmentScore(88.1);
        student2.addAssignmentScore(89.3);
        student2.addExamScore(85);
        student2.addExamScore(87);
        
        //new roster
        Roster undisputed = new Roster("Undisputed","UND101");
        undisputed.addStudent(student);
        undisputed.addStudent(student2);
        
        //test the roster traversal
        System.out.println("Undisputed grades:");
        AvgDispenser undisputedIterator = undisputed.createDispenser();
        while (undisputedIterator.hasNextAvg()) {
            System.out.println("next average "  + df.format(undisputedIterator.getNextAvg()));
        }

    }
}
