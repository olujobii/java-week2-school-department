package com.olujobii;

import java.util.List;

public interface AdminPriviledges {

    boolean enrollStudent(Applicant applicant);

    boolean expelStudent(List<Student> students);
}
