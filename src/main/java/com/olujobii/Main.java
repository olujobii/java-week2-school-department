package com.olujobii;

import com.olujobii.presentation.SchoolMgtSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SchoolMgtSystem schoolMgtSystem = new SchoolMgtSystem(new Scanner(System.in));

        schoolMgtSystem.runApplication();

    }
}
