package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.ParticipantDetails;

public interface ParticipantDetailsRepo extends JpaRepository<ParticipantDetails,Integer>{
	

}
