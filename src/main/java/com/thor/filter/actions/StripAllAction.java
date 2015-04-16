package com.thor.filter.actions;

import org.jsoup.nodes.Element;

public class StripAllAction extends Action {
    public static final Action INSTANCE = new StripAllAction();
    
    @Override
    public void apply(Element element) {
        element.remove();
    }

}
