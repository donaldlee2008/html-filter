package com.thor.filter.actions;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

public class StripTagAction extends Action {
    public static final Action INSTANCE = new StripTagAction();
    @Override
    public void apply(Element element) {
        element.replaceWith(new Element(Tag.valueOf("span"), StringUtils.EMPTY).text(element.text()));
    }
    
}
