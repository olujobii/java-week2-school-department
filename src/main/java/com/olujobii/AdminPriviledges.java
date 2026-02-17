package com.olujobii;

import java.util.List;

public interface AdminPriviledges {

    boolean enrollStudent(Applicant applicant);

    boolean expelStudent(Student student);

    boolean approveCourseAddition(Course course, List<Course> availableCourses);

    boolean approveCourseRemoval(Course course, List<Course> availableCourses);
}
