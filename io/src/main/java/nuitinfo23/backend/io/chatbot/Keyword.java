package nuitinfo23.backend.io.chatbot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    private String name;// keyword name
    private String target;// Target state id
    private int value;// The value appointed to the target state when the keyword is parsed

}
