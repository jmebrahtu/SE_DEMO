package edu.miu.cs425.studentregistrar.service.impl;

import edu.miu.cs425.studentregistrar.model.Student;
import edu.miu.cs425.studentregistrar.repository.StudentRepository;
import edu.miu.cs425.studentregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    @Autowired
    // constructor
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    // retrived all the students
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    // add a new student to the data base or register a new student
    public Student registerNewStudent(Student newStudent) {
        return studentRepository.save( newStudent );
    }

    @Override
    // populate all the student and sorted by lastName.
    public List<Student> getAllStudentSorted() {
        return studentRepository.findAll(Sort.by("lastName"));
    }

    //retrived  students by Id or if does not exist on the db return null
    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    // update student

    @Override
    public Student updateStudent(Student updStudent, long studentId) {
        if (studentRepository.findById(studentId).isPresent()) {
            Student existingStudent = studentRepository.findById(studentId).get();
            existingStudent.setFirstName(updStudent.getFirstName());
            existingStudent.setMiddleName(updStudent.getMiddleName());
            existingStudent.setLastName(updStudent.getLastName());
            existingStudent.setStudentNumber(updStudent.getStudentNumber());
            existingStudent.setCgpa(updStudent.getCgpa());
            existingStudent.setInternational(updStudent.getIsInternational());
            existingStudent.setDateOfEnrollemnet(updStudent.getDateOfEnrollemnet());

            Student updatedStudent = studentRepository.save(existingStudent);
            return  updatedStudent;
        } else {
            return null;
        }

    }


    @Override
    public void deleteStudentById(long studentId) {
        studentRepository.deleteById(studentId);

    }
}
