package com.cs5800.lab4;

import java.text.DecimalFormat;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class StudentTest{

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
	public void testSwitchingAlgorithms(){
		//algorithm A:
		double avg = student.getAverage();
		assertEquals(91.6, avg, 0.1);
        // switch to algorithm B:
        student.setDropLowestAssign(true);
        avg = student.getAverage();
		assertEquals(92.6, avg, 0.1);
        // switch back to algorithm A:
		student.setDropLowestAssign(false);
		avg = student.getAverage();
		assertEquals(91.6, avg, 0.1);
	}

}
