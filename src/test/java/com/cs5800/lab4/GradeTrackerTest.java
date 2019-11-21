package com.cs5800.lab4;

import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;
import org.junit.*;

public class GradeTrackerTest {

	Student student;
	DecimalFormat df = new DecimalFormat("0.0");

	@Before
	public void setUpStudent(){
		student = new Student("Skip Bayless");
        student.addAssignmentScore(93.5);
        student.addAssignmentScore(92.1);
        student.addAssignmentScore(85.0);
        student.addExamScore(96);
		student.addExamScore(89);
	}

	@Test
	public void testTrackerUpdatingLetterGrade(){
        GradeTracker gt = new GradeTracker(student);

        //check initial letter grade
        char letterGrade = gt.getLetterGrade();
        assertEquals('A', letterGrade);

        //add a new exam score that will change the letter grade
        student.addExamScore(10.0);
        letterGrade = gt.getLetterGrade();
        assertEquals('C', letterGrade);
	}
    
}