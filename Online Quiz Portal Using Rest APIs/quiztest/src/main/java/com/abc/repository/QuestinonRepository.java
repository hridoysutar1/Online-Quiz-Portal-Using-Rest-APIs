package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Question;

public interface QuestinonRepository extends JpaRepository<Question, Long> {

}
