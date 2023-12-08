package nuitinfo23.backend.io.chatbot;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {
    private String id;
    private ArrayList<String> messages; /* The possible answer messages */
    private String source_link;
    private ArrayList<Keyword> keywords; /* All keywords (in String for same reason as in parser) */
    private int value; /* integer used to determine the state we go to with it the highest value */


    State(String id, String url, int value, ArrayList<String> messages, ArrayList<Keyword> keywords){
        this.id = id;
        source_link = url;
        this.value = value;
        this.messages = messages;
        this.keywords = keywords;
    }
    public void incr(String s) {
        for (Keyword kw : keywords) {
            if (s.equalsIgnoreCase(kw.getName())) {
                value += kw.getValue();
            }

        }

    }
}
