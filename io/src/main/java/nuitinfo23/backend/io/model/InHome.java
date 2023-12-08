package nuitinfo23.backend.io.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InHome")
public class InHome  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_h;
    private String image_url; /* */
    private String brief_explanation;


   
}
