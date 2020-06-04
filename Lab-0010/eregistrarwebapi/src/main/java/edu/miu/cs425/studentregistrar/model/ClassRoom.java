package edu.miu.cs425.studentregistrar.model;//package edu.miu.cs425.studentmgmt.model;
//
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.util.List;
//
//@Entity
//@Table
//public class ClassRoom {
//    // attribute
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotBlank(message = "classroomId is required")
//    @Column(name="classroomId",unique = true,nullable = false)
//    private long classroomId;
//    private String buildingName;
//    private String roomNumber;
//
//    @OneToMany(mappedBy = "classRoom",cascade = CascadeType.ALL)
//    private List<Student> studentList;
//
//// deafault constructor
//    public ClassRoom() {
//    }
//
//    public ClassRoom(@NotBlank(message = "classroomId is required") long classroomId, String buildingName, String roomNumber, List<Student> studentList) {
//        this.classroomId = classroomId;
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//        this.studentList = studentList;
//    }
//
//    public ClassRoom(String buildingName, String roomNumber, List<Student> studentList) {
////        this.classroomId = classroomId;
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//        this.studentList = studentList;
//    }
//    public ClassRoom(String buildingName, String roomNumber) {
//
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//    }
//
//    public ClassRoom(@NotBlank(message = "classroomId is required") Integer classroomId) {
//        this.classroomId = classroomId;
//    }
//
//    public long getClassroomId() {
//        return classroomId;
//    }
//
//    public void setClassroomId(long classroomId) {
//        this.classroomId = classroomId;
//    }
//
//    public String getBuildingName() {
//        return buildingName;
//    }
//
//    public void setBuildingName(String buildingName) {
//        this.buildingName = buildingName;
//    }
//
//    public String getRoomNumber() {
//        return roomNumber;
//    }
//
//    public void setRoomNumber(String roomNumber) {
//        this.roomNumber = roomNumber;
//    }
//
//    public List<Student> getStudentList() {
//        return studentList;
//    }
//
//    public void setStudentList(List<Student> studentList) {
//        this.studentList = studentList;
//    }
//
//
//    @Override
//    public String toString() {
//        return "ClassRoom{" +
//                "classroomId=" + classroomId +
//                ", buildingName='" + buildingName + '\'' +
//                ", roomNumber=" + roomNumber +
//                ", studentList=" + studentList +
//                '}';
//    }
//
//    public void addStudent(List<Student> stlist) {
//        for(Student s:stlist){
//            s.setClassRoom(this);
//        }
//    }
//}
