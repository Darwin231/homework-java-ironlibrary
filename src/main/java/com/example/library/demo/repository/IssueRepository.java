package com.example.library.demo.repository;

import com.example.library.demo.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
    Optional<Issue> findByIssueId(int issueId);
}
