package nuitinfo23.backend.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nuitinfo23.backend.io.model.InQuiz;

@Repository
public interface InQuizRepository extends JpaRepository<InQuiz,Integer> {

    @Query("SELECT keyword1, keyword2, keyword3, id_q FROM InQuiz")
    List<String> getKeywordsandId();

  

}
