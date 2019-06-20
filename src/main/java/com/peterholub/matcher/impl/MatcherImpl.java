package com.peterholub.matcher.impl;

import com.peterholub.matcher.Matcher;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of FileLoader interface
 */
public class MatcherImpl implements Matcher {
    /**
     * Method to compere element attributes
     *
     * @param example       object as example
     * @param toCompare     object to compare to find similar attributes
     * @param valuesAndKeys list of matched attributes to print
     * @return value of amount matched attributes
     */
    @Override
    public int compareElement(Element example, Element toCompare, List<String> valuesAndKeys) {
        final Map<String, String> originAttributes = extractAttributes(example);
        final Map<String, String> comparableAttributes = extractAttributes(toCompare);

        return originAttributes
                .keySet()
                .stream()
                .filter(comparableAttributes::containsKey)
                .mapToInt(key -> {
                    final String comparableValue = comparableAttributes.get(key);
                    final String originValue = originAttributes.get(key);
                    if (comparableValue.equals(originValue)) {
                        valuesAndKeys.add(String.format("Attribute '%s' with value: '%s' matched", key, comparableValue));
                        return 1;
                    }
                    return 0;
                })
                .sum();
    }

    /**
     * Method to extract attributes from element
     *
     * @param element element to extract attributes
     * @return attributes as key and value
     */
    private Map<String, String> extractAttributes(Element element) {
        return element.attributes()
                .asList()
                .stream()
                .collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
    }
}
