package com.peterholub.xpatchbuilder;

import org.jsoup.nodes.Element;

/**
 * Defines method for getting XPatch from Element
 */
public interface XPatchBuilder {
    /**
     * @param element Element from DOM to get XPatch
     * @return String object representing element patch
     */
    String getXPatch(Element element);

}
