//package edu.miu.cs425.studentmgmt.repository;
//
//import edu.miu.cs425.studentmgmt.model.Student;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query("select s from Student s where s.studentId = :studentId")
////    Student findByStudnetNAndStudentNumber(@Param("studentNumber")String studentNumber);
//   Student findByStudentId(@Param("studentId") long studentId);
//
//    //@Query(value = "SELECT s FROM Student WHERE lastName like %:lastname%")
//    public List<Student> findByLastName(String lastname);
//
//    List<Student> findByFirstNameContaining(String firstName);
//
//    @Query(value = "SELECT * FROM Student s WHERE s.F_NAME = ?1", nativeQuery = true)
//    public List<Student> findByFirstName(String firstName);
//
//    public List<Student> findStudentByLastName(@Param("lastName") String lastName);
//
//    List<Student> findAllByfirstNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(String firstName,
//                                                                                                            String lastName,
//                                                                                                            String studentNumber);
//    List<Student> findAllByDateOfEnrollemnetEquals(LocalDate dateOfEnrolllemnt);
//    List<Student> findAllByCgpaEquals(Double cGpa);
//
//    // More queries
//    List<Student> findStudentByDateOfEnrollemnetIsStartingWith(String str);
//
//
//}
//
//
