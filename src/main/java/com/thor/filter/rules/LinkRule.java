package com.thor.filter.rules;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.thor.filter.actions.Action;
import com.thor.filter.actions.StripTagAction;

public class LinkRule extends Rule {
    public static final LinkRule INSTANCE_WITH_STRIP_TAG_ACTION = new LinkRule();
    
    private final Action action;
    
    private LinkRule() {
        this.action = StripTagAction.INSTANCE;
    }
    
    public LinkRule(Action action) {
        super();
        this.action = action;
    }

    @Override
    public Elements getElement(Document document) {
        return document.select("a");
    }

    @Override
    public Action getAction() {
        // TODO Auto-generated method stub
        return action;
    }
    
}
