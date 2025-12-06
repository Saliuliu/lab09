package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
    * @param next the next string to print, must not be null
    * @throws NullPointerException if next is null
    */
    public void setNextString(String next);

    /**
    * @return the next string that will be printed
    */
    public String getNextString();

    /**
    * @return a List of string that rapresents the history of printed string
    */
    public List<String> getHistory();

    /**
    * Print the current string to the standard output
    * @throws IllegalStateException if the current string is unset
    */
    public void printCurrentString();
}
