package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;



import java.time.LocalDate;


public class Student implements Comparable {
    private int studentId;
    private String name;
   private LocalDate dateOfAdmission;

    public Student() {

    }
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student(int studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;

    }

    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;

    }


    public  LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }




    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;

    }


    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Student) o).getName());
    }

    @Override
    public String toString(){
        return ("Student_id: "+this.getStudentId()+"\n"+"student_name: "
                + this.getName()+"\n"+"dat_of_admission: "+this.getDateOfAdmission()+"\n\n");
    }

}
