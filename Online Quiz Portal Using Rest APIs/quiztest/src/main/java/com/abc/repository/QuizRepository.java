package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long>{

}
