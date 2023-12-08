package nuitinfo23.backend.io.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nuitinfo23.backend.io.model.InHome;
import nuitinfo23.backend.io.repository.InHomeRepository;

@Service
public class InHomeServiceImp implements InHomeService {
    @Autowired
    private InHomeRepository inhomerepository;

    @Override
    public List<InHome> getAllHomePropositions() {
        return  inhomerepository.findAll();
    }
}