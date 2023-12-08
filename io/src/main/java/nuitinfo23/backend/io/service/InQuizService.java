package nuitinfo23.backend.io.service;

import java.util.List;

import nuitinfo23.backend.io.model.InQuiz;

public interface InQuizService {

    public List<InQuiz> getAllQuizPropositions();

    public List<InQuiz> getAllTrue();

    public List<InQuiz> getAllFalse();

    
    }
    
