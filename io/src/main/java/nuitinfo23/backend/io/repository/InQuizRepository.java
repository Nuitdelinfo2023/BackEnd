package nuitinfo23.backend.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nuitinfo23.backend.io.model.InQuiz;

@Repository
public interface InQuizRepository extends JpaRepository<InQuiz,Integer> {
    
}
