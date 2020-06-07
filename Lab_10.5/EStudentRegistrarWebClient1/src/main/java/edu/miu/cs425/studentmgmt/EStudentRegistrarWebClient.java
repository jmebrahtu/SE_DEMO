package edu.miu.cs425.studentmgmt;

;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class EStudentRegistrarWebClient {
    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(EStudentRegistrarWebClient.class, args);
    }
}






//
//    @Autowired
//    StudentRepository studentRepository;
//    @Autowired
//    ClassRoomRepository classRoomRepository;
//    @Autowired
//    TranscriptRepository transcriptRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
////        ClassRoom clas1 = new ClassRoom("McLaughlin building", "M105");
//
//        Transcript tran1 = new Transcript("BS Computer Science");
//        Transcript tran2 = new Transcript("BS Computer Science");
//
//
//        Student st1 = new Student("000-61-0001",
//                "Jirom", "henok", "senay",
//                3.4, LocalDate.of(2018, 5, 3), tran1,"Yes");
//
//        Student st2 = new Student("000-61-0009",
//                "Selam", "Abel", "Henok",
//                3.3, LocalDate.of(2017, 9, 6), tran2,"NO");
//
//        List<Student> stlist = Arrays.asList(st1, st2);
////        saveStudent(st1);

//        clas1.setStudentList(stlist);
////        clas1.addStudent(stlist);
//
//
//        //  Transcript t1= saveTranscript(tran);
////       System.out.println(t1);
//
////        ClassRoom cl= saveClassroom(clas1);
////        System.out.println(cl);
////
////    }

//    private Student saveStudent(Student student){
//        return  studentRepository.save(student);
//    }


//    private ClassRoom saveClassroom(ClassRoom classRoom){
//        return classRoomRepository.save(ClassRoom classRoom);
//    }





