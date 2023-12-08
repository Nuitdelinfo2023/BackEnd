package nuitinfo23.backend.io.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nuitinfo23.backend.io.model.InQuiz;
import nuitinfo23.backend.io.repository.InQuizRepository;

@Service
public class InQuizServiceImp implements InQuizService {
    @Autowired
    private InQuizRepository inquizrepository;

    @Override
    public List<InQuiz> getAllQuizPropositions() {
        return inquizrepository.findAll();
    }

    @Override
    public List<InQuiz> getAllTrue() {
        List<InQuiz> list = new ArrayList<>();
        for (InQuiz c : inquizrepository.findAll()) {
            if (c.isFact()) {
                list.add(c);
            }
        }
        return list;
    }

    @Override
    public List<InQuiz> getAllFalse() {
        List<InQuiz> list = new ArrayList<>();
        for (InQuiz c : inquizrepository.findAll()) {
            if (!c.isFact()) {
                list.add(c);
            }
        }
        return list;
    }
}