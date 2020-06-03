//package edu.miu.cs425.studentmgmt.model;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//// class
//@Entity
//@Table(name = "transcripts")
//
//public class Transcript {
//
//    // attribute later becames column in the table
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotBlank(message = "transcriptID is required")
//    @Column(name = "TranscriptId", unique = true, nullable = false)
//    private long transcriptID;
//    private String degreeTitle;
//
//    // default constructor
//    public Transcript() {
//    }
//
//    // one parameterized constructor
//    public Transcript(String degreeTitle) {
//        this.degreeTitle = degreeTitle;
//    }
//
//    // parameterized constuctor
//    public Transcript(@NotBlank(message = "transcriptID is required")long transcriptID, String degreeTitle) {
//        this.transcriptID = transcriptID;
//        this.degreeTitle = degreeTitle;
//    }
//
//
//    public long getTranscriptID() {
//        return transcriptID;
//    }
//
//    public void setTranscriptID(long transcriptID) {
//        this.transcriptID = transcriptID;
//    }
//
//    public String getDegreeTitle() {
//        return degreeTitle;
//    }
//
//    public void setDegreeTitle(String degreeTitle) {
//        this.degreeTitle = degreeTitle;
//    }
//
//    @Override
//    public String toString() {
//        return "Transcript{" +
//                "transcriptID=" + transcriptID +
//                ", degreeTitle='" + degreeTitle + '\'' +
//                '}';
//    }
//}
