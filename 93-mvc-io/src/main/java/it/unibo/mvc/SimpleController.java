package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private List<String> history;

    public SimpleController(){
        this.nextString = null;
        this.history = new LinkedList<>();
    }

    @Override
    public void setNextString(String next) {
        if (next == null) {
            throw new NullPointerException("next must not be null");
        }
        this.nextString = next;
    }

    @Override
    public String getNextString() {
        return nextString;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public void printCurrentString() {
        if (nextString == null) {
            throw new IllegalStateException("Next string must be set");
        }
        System.out.println(nextString);
        history.add(nextString);
    }
}
