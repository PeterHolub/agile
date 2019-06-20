package com.peterholub.xpatchbuilder.impl;

import com.peterholub.xpatchbuilder.XPatchBuilder;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XPatchBuilderImpl implements XPatchBuilder {

    /**
     * @param htmlElement Element from DOM to get XPatch
     * @return String object representing element patch
     */
    @Override
    public String getXPatch(Element htmlElement) {
        StringBuilder xPath = new StringBuilder();
        //Getting parents of element
        Elements parents = htmlElement.parents();

        //Appending the first DOM element (HTML)
        xPath.append("/");
        xPath.append(parents.get(parents.size() - 1).tagName());


        //Getting indexes of parents
        for (int j = parents.size() - 1; j >= 0; j--) {
            removeDuplicateTags(xPath, parents, j);
        }

        return xPath.toString();
    }

    /**
     * Method helper to remove duplicate tags to calculate properly parents indexes
     *
     * @param xPath   StringBuilder to create Xpath
     * @param parents element to remove
     * @param j       counter
     */
    private void removeDuplicateTags(StringBuilder xPath, Elements parents, int j) {
        List<Element> list = new ArrayList<>();

        //Retrieving one by one element starting from the last
        Element element = parents.get(j);

        if (j > 0) {
            //Retrieving duplicate tags
            Element elementInner = parents.get(j-1);


            for (Element child : element.children()) {
                if (child.tagName().equals(elementInner.tagName())) {
                    list.add(child);
                }
            }

            xPath.append("/");
            xPath.append(elementInner.tagName());
            xPath.append("[");
            xPath.append(list.indexOf(elementInner) + 1);
            xPath.append("]");
        }
    }
}

