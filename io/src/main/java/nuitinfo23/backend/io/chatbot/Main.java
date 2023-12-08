package nuitinfo23.backend.io.chatbot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import nuitinfo23.backend.io.model.InQuiz;
import nuitinfo23.backend.io.repository.InQuizRepository;
@Component
public class Main {
    ArrayList<State> states = new ArrayList<State>(); /*All states */
    ArrayList<Keyword> keywords = new ArrayList<Keyword>(); /* All keywords */
    List<String> keywords_names = new ArrayList<String>(); /*All keywords' names (for parser) */
    ArrayList<String> messages = new ArrayList<String>(); /* The possible answer messages */
    public Parser dataparser = new Parser(keywords_names,null);
    public Bot mainbot = new Bot(messages,states);
    State currentState;
   
    @Autowired
    private InQuizRepository inquizrepository;


    

    @PostConstruct
    public void init(){
       List<InQuiz> list = inquizrepository.findAll();
       for (InQuiz temp : list){
        keywords.add(new Keyword(temp.getKeyword1(),String.valueOf(temp.getId_q()),3));
        keywords.add(new Keyword(temp.getKeyword2(),String.valueOf(temp.getId_q()),2));
        keywords.add(new Keyword(temp.getKeyword3(),String.valueOf(temp.getId_q()),1));
        keywords_names.add(temp.getKeyword1());
        keywords_names.add(temp.getKeyword2());
        keywords_names.add(temp.getKeyword3());
        messages.add(temp.getProposition() + " " + temp.isFact() + " " + temp.getExplanation1());
        messages.add(temp.getProposition() + " " + temp.isFact() + " " + temp.getExplanation2());
        messages.add(temp.getProposition() + " " + temp.isFact() + " " + temp.getExplanation3());
        states.add(new State(String.valueOf(temp.getId_q()),temp.getSource_link(), 0,messages,keywords));
       } 
       currentState = states.get(0);
       




       }

       }

    


