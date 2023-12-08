package nuitinfo23.backend.io.chatbot;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parser {
    private List<String> keywords; /*
                                * all keywords (they are string because they only detect if the keyword is present,
                                * not which instance it is)
                                */
    private String buffer; /* Where we load the messages to parse them */

    public List<String> detect() {
        List<String> res = new ArrayList();
        String[] words = buffer.split(" ");
        for (String word : words) {
            for (String temp : keywords) {
                if (word.equalsIgnoreCase(temp)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }

}
