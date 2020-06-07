package edu.miu.cs425.studentregistrar.model;

import java.util.List;

public class Students {
    private List<Student>stu;

    public  List<Student>getStudents(){
        return stu;
    }

    public void setStudents(List<Student>stu) {
        this.stu= stu;
    }
}
