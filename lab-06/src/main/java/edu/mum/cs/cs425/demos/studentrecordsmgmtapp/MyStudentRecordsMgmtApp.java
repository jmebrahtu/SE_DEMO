package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.Model.Student;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    // static must be added
    public   void main(String[] args) {

        DateTimeFormatter changethestring = DateTimeFormatter.ofPattern("MM/dd/yyy");

        Student s1 = new Student(110001, "Dave", LocalDate.parse("11/18/1951", changethestring));
        Student s2 = new Student(110002, "Anna", LocalDate.parse("12/07/1990", changethestring));
        Student s3 = new Student(110003, "Dave", LocalDate.parse("01/31/1974", changethestring));
        Student s4 = new Student(110004, "Erica", LocalDate.parse("08/22/2009", changethestring));
        Student s5 = new Student(110005, "Bob", LocalDate.parse("03/05/1990", changethestring));


        Student[] students = {s1, s2, s3, s4, s5};

        //List<Student> students= Arrays.asList(s1,s2,s3,s4,s5);
        System.out.println("print name in ascending order");
        printListOfStudents(students);

        System.out.println("-----------------------------------------------");
//        List<Student>st= getListOfPlatinumAlumniStudents(students);
//   for(Student s:st);
//        System.out.println(s);
        System.out.println("print List Of PlatinumAlumni Students");
        System.out.println( "----------------------------------------" );

        System.out.println( "-------------Hello World based on multiplicity of 5 and 7 -------" );

        printHelloWorld(new int[]{5,2,7,4,35});

        System.out.println( "----------------------------------------" );

        System.out.println( "-------------Second biggest-------" );

        findSecondBiggest(new int[]{22,45,72,12,94});

        System.out.println( "----------------------------------------" );



        getListOfPlatinumAlumniStudents(students).forEach(System.out::println);

    }

    public void printListOfStudents(Student[] students) {
        List<Student> studentList = Arrays.asList(students);
        Collections.sort(studentList);

        System.out.println(students);
    }
    // using reference method =>::
// Arrays.stream(students)
    //.sorted(comparator.comparing(Student::getName))
   // .forEach(System.out::println);

    public List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> stulist = Arrays.asList(students);
        for (Student s : students) {
            if (Period.between(s.getDateOfAdmission(), LocalDate.now()).getYears() >= 30) {
                stulist.add(s);

            }
        }
        // return Arrays.stream(students)
        //.fliter(Student::isPlatinumAlumniStudent)
        //.sorted(Comparator.comparing(Student::getDateOfAdminssion).reversed())
        //.collect(Collectors.toList());
        return stulist.stream().sorted((o1, o2) -> o1.getDateOfAdmission().
                compareTo(o2.getDateOfAdmission())).collect(Collectors.toList());


    }
    public static void printHelloWorld(int[] num){
        for(int i:num){
            if(i%5==0 && i%7==0)
                System.out.println("HelloWorld");
            else if(i%5==0)
                System.out.println("Hello");
            else if(i%7==0)
                System.out.println("World");
        }
    }
    public static int findSecondBiggest(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int i : nums) {
            if (i > max1) {
                max1 = i;
            }
            for (int k : nums) {
                if (k > max2 && k < max1) {
                    if (k > max2) {
                        max2 = k;
                    }

                }

            }

        }
        return max2;

    }


    // TO Do ----JSON format
    private void printStudentsDataInJSONFormat(Student[]students){
        //do something
    }
    private void printStudentsDataInXMLFormat(Student[]students) {
        //do something
    }

    }






