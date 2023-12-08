package nuitinfo23.backend.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nuitinfo23.backend.io.model.InQuiz;
import nuitinfo23.backend.io.service.InQuizService;

@RestController
@RequestMapping("/quiz")
public class InQuizController {
  @Autowired
  private InQuizService inquizservice;

  @GetMapping("/all")
  public List<InQuiz> getAllQuiz() {
    return inquizservice.getAllQuizPropositions();
  }

  @GetMapping("/true")
  public List<InQuiz> getAllTrue() {
    return inquizservice.getAllTrue();
  }

  @GetMapping("/false")
  public List<InQuiz> getAllFalse() {
    return inquizservice.getAllFalse();
  }
}
