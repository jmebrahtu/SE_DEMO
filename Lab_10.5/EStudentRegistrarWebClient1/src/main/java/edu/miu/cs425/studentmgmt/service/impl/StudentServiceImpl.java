package edu.miu.cs425.studentmgmt.service.impl;

import edu.miu.cs425.studentmgmt.model.Student;
import edu.miu.cs425.studentmgmt.model.Students;

import edu.miu.cs425.studentmgmt.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
    RestTemplate restTemplate ;
    String mainURL= "http://localhost:8080/mystudentsmgmt/api/student";

    // get all  students
    @Override
    public List<Student> getAllStudents() {
        System.out.println("list");
        Students st = restTemplate.getForObject("http://localhost:8080/mystudentsmgmt/api/student/list", Students.class);
        System.out.println("list");
        return st.getStu();
        //System.out.println("op");
        //return st;
//        if (stulist!=null)
//            return stulist.getStudents();
//        return null;
    }

//    // save of a new  student
    @Override
   public Student registerNewStudent(Student newStudent) {
        return  restTemplate.postForObject(mainURL+"/register",newStudent,Student.class);
  }

//// get the JSON object by ID
   @Override
    public Student getStudentById(long studentId) {
        return restTemplate.getForObject(mainURL+"/get/"+studentId,Student.class);
   }

   // update

    @Override
   public void updateStudent(Student updStudent, long studentId) {
         restTemplate.put(mainURL + "/update/" + studentId, Student.class);
   }

    // delete student by id
   @Override
    public void deleteStudentById(long studentId) {
           restTemplate.delete(mainURL+"/delete/"+studentId,Student.class);
    }

    // save student
    @Override
    public Student save(Student student) {
        return  restTemplate.postForObject(mainURL+"/register",student,Student.class);
    }


}



//    @Override
//    public Page<Student> getAllStudentPaged( int pageNo ,int size) {
//       // return  studentRepository.findAll(PageRequest.of(pageNo);
//        return studentRepository.findAll(PageRequest.of(pageNo, size, Sort.by("firstName")));
//    }

//    // Search method(searching based a given attribute(value)
//    @Override
//    public List<Student> searchStudent(String searchString) {
//        if(containsDecimalPoint(searchString) && isCGPA(searchString)) {
//            return studentRepository.findAllByCgpaEquals(Double.parseDouble(searchString));
//
//        } else if(isDate(searchString)) {
//            return studentRepository.findAllByDateOfEnrollemnetEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
//        } else {
//            return studentRepository.findAllByfirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(searchString,searchString,searchString);
//            //astNameContainingOrStudentNumberContainingOrderByStudentId(searchString, searchString, searchString);
//        }
//    }

//    private boolean isCGPA(String searchString) {
//        boolean isParseableAsCGPA = false;
//        try {
//            Double.parseDouble(searchString);
//            isParseableAsCGPA = true;
//        } catch(Exception ex) {
//            if(ex instanceof ParseException) {
//                isParseableAsCGPA = false;
//            }
//        }
//        return isParseableAsCGPA;
//
//
//    }
//

//    private boolean isDate(String searchString) {
//        boolean isParseableAsDate = false;
//        try {
//            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
//            isParseableAsDate = true;
//        } catch (Exception ex) {
//            if (ex instanceof DateTimeParseException) {
//                isParseableAsDate = false;
//            }
//        }
//        return isParseableAsDate;
//    }
//
//    private boolean containsDecimalPoint(String searchString) {
//        return searchString.contains(".");
//    }






