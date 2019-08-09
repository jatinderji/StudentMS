package com.jatin.studentms;

public class Student
{
    private String sname;

    public String getSname() {
        return sname;
    }

    public Long getMnumber() {
        return mnumber;
    }

    private Long mnumber;

    Student(String n,Long m)
    {
        sname =n;
        mnumber = m;
    }

}