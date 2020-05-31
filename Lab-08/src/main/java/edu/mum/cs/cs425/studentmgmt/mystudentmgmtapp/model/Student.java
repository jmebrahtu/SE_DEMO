package edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
// class
@Entity
@Table(name = "students")
public class Student{

    // These are attributes=> later becomes column in the table
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @NotBlank(message="studentId is required")
     @Column(name = "studentId",unique = true,nullable = false)
    private long studentId;
    @NotBlank(message="studentNumber is required")
    private String studentNumber;
     @NotBlank(message="FirstName is required")
    private String firstName;
     private String middleName;
    @NotBlank(message="lastName is required")
    private String lastName;
     private double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private LocalDate dateOfEnrollemnet;

// relationship b/n Student and Transcript
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript",nullable = false)
    private Transcript transcript;

    // relationship b/n student and classroom
    @ManyToOne
    @JoinColumn(name ="classRoom")
    private ClassRoom classRoom;


// default constructor;
    public Student() {
    }

    // parameterized constructor
    public Student(@NotBlank(message = "studentId is required") long studentId, @NotBlank(message = "studentNumber is required")
            String studentNumber, @NotBlank(message = "FirstName is required") String firstName, String middleName, @NotBlank(message = "lastName is required")
            String lastName, double cgpa, LocalDate dateOfEnrollemnet, Transcript transcript, ClassRoom classRoom) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollemnet = dateOfEnrollemnet;
        this.transcript = transcript;
        this.classRoom = classRoom;
    }

    public Student( @NotBlank(message = "studentNumber is required")
            String studentNumber, @NotBlank(message = "FirstName is required") String firstName, String middleName, @NotBlank(message = "lastName is required")
                           String lastName, double cgpa, LocalDate dateOfEnrollemnet, Transcript transcript) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollemnet = dateOfEnrollemnet;
        this.transcript = transcript;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollemnet() {
        return dateOfEnrollemnet;
    }

    public void setDateOfEnrollemnet(LocalDate dateOfEnrollemnet) {
        this.dateOfEnrollemnet = dateOfEnrollemnet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollemnet=" + dateOfEnrollemnet +
                ", transcript=" + transcript +
                '}';
    }
}
