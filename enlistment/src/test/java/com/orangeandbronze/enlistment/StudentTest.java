package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.orangeandbronze.enlistment.Days.*;
import static com.orangeandbronze.enlistment.Period.*;
public class StudentTest {

	
	@Test
	public void enlistTwoSectionsNoSchedConflict(){
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P0830);
		Schedule sched2 = new Schedule(Days.TF, Period.P1000);
		Section sec1 = new Section("ABC", sched1,new Room("RM1"));
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"));		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
		
	}

	@Test(expected = ScheduleconflictException.class)
	public void enlistTwoSectionsSameSchedule(){
		
		Student student = new Student(1);
		Schedule sched1 = new Schedule(Days.MTH, Period.P0830);
		Schedule sched2 = new Schedule(Days.MTH, Period.P0830);
		Section sec1 = new Section("ABC", sched1, new Room("RM1"));
		Section sec2 = new Section("XYZ", sched2,new Room("RM2"));		
		
		student.enlist(sec1);
		student.enlist(sec2);
		
		assertTrue(student.getSections().contains(sec1));
		assertTrue(student.getSections().contains(sec2));
		
		
		
	}
	
}
