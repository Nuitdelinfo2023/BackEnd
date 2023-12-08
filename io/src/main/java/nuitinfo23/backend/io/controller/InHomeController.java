package nuitinfo23.backend.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nuitinfo23.backend.io.model.InHome;
import nuitinfo23.backend.io.service.InHomeService;

@RestController
@RequestMapping("/home")
public class InHomeController {
    @Autowired
    private InHomeService inhomeservice;

    @GetMapping("/all")
    public List<InHome> getPropositions() {
        return inhomeservice.getAllHomePropositions();
    }

}
