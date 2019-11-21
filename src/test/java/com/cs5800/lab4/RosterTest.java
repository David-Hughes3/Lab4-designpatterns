package com.cs5800.lab4;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;

public class RosterTest {
    
    Roster undisputed;
	DecimalFormat df = new DecimalFormat("0.0");


    @Before
    public void setUpRoster(){
        Student student = new Student("Skip Bayless");
        student.addAssignmentScore(93.5);
        student.addAssignmentScore(92.1);
        student.addAssignmentScore(85.0);
        student.addExamScore(96);
        student.addExamScore(89);
        
        Student student2 = new Student("Shannon Sharpe");
        student2.addAssignmentScore(86.2);
        student2.addAssignmentScore(88.1);
        student2.addAssignmentScore(89.3);
        student2.addExamScore(85);
        student2.addExamScore(87);

        undisputed = new Roster("Undisputed","UND101");
        undisputed.addStudent(student);
        undisputed.addStudent(student2);
    }



	@Test
	public void testRosterIterator(){

        AvgDispenser undisputedIterator = undisputed.getDispenser();

        double avg = undisputedIterator.getNextAvg();
        assertEquals(91.6, avg, 0.1);
        
        avg = undisputedIterator.getNextAvg();
        assertEquals(86.7, avg, 0.1);

	}
 
}
