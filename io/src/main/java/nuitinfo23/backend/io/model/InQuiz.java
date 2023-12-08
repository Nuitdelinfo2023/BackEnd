package nuitinfo23.backend.io.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InQuiz")
public class InQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_q;
    private String proposition; /* The proposition we'll drag in the quiz */
    private boolean fact; /* Whether the proposition is true or false */
    private String explanation1; /* We'll have numerous explanations that get more detailed in ascending order */
    private String explanation2;
    private String explanation3;
    private String source_link; /* Url of the source article of the explanation */
    private String keyword1; /* We'll have 2 or 3 keywords for each proposition */
    private String keyword2;
    private String keyword3;

}
