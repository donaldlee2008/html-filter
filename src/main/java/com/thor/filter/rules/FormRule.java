package com.thor.filter.rules;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.thor.filter.actions.Action;
import com.thor.filter.actions.StripAllAction;

public class FormRule extends Rule {
    private final Action action;
    
    public static final FormRule INSTANCE_WITH_STRIP_ALL_ACTION = new FormRule();
    
    private FormRule() {
        super();
        this.action = StripAllAction.INSTANCE;
    }

    public FormRule(Action action) {
        super();
        this.action = action;
    }

    @Override
    public Action getAction() {
        // TODO Auto-generated method stub
        return action;
    }

    @Override
    public Elements getElement(Document document) {
        // TODO Auto-generated method stub
        return document.select("form");
    }
    
}
