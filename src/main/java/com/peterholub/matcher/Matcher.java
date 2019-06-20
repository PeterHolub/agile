package com.peterholub.matcher;

import org.jsoup.nodes.Element;

import java.util.List;

/**
 * Defines method for compering DOM elements
 */
public interface Matcher {
    /**
     * Method to compere element attributes
     *
     * @param example   object as example
     * @param toCompare object to compare to find similar attributes
     * @return  value of amount matched attributes
     */
    int compareElement(Element example, Element toCompare, List<String> valuesAndKeys);
}
