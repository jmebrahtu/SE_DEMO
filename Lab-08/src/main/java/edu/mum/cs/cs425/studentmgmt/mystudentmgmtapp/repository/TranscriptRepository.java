package edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.repository;

import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model.Transcript;

import org.springframework.data.repository.CrudRepository;

public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {

}
