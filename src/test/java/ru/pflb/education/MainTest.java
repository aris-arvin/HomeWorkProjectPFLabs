package ru.pflb.education;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class MainTest {
    Main main;

    @BeforeClass
    public void setUp(){
        main = new Main();
    }

    @BeforeMethod
    public void showThread(){
        System.out.println((Thread.currentThread().getId()));
    }











}
