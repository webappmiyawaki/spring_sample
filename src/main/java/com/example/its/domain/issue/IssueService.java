package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll(){
        return issueRepository.findAll();
    }

    @Transactional
    public void create(String id,String summary,String description){
        issueRepository.insert(id,summary,description);
    }

    @Transactional
    public void delete(String summary){
        issueRepository.delete(summary);
    }

    public IssueEntity findById(String issueId){
        return issueRepository.findById(issueId);
    }
}
