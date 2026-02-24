package com.olujobii;

import com.olujobii.controller.SchoolMgtSystemController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SchoolMgtSystemController schoolMgtSystemController = new SchoolMgtSystemController(new Scanner(System.in));

        schoolMgtSystemController.runApplication();

    }
}
