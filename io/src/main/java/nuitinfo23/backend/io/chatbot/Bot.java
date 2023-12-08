package nuitinfo23.backend.io.chatbot;
import java.util.ArrayList;
import java.util.List;


public class Bot {
    ArrayList<String> tabString; /*Output of parser */
    ArrayList<State> tabState; /* All states */

    public Bot(ArrayList<String> tabk, ArrayList<State> tabs) {
        this.tabString = tabk;
        tabState = tabs;
    }

    public State keywordToState() {
        for (String s : tabString) {
            for (State state : tabState) {
                state.incr(s);
            }
        }
        State statef = tabState.get(0);
        for (State state : tabState) {
            if (statef.getValue() < state.getValue())
                statef = state;
        }
        for (State state : tabState) {
            state.setValue(0);
        }
        return statef;
    }

    public String getOutput(State s){
        ArrayList<String> a= s.getMessages();
        int i =(int) (Math.random()*a.size());
        return a.get(i);
    }
    public void setBuffer(List<String> list){
        tabString = (ArrayList<String>) list;
    }

}
