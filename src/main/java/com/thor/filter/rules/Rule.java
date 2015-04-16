package com.thor.filter.rules;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.thor.filter.actions.Action;

public abstract class Rule {
    public abstract Elements getElement(Document document);
    
    public abstract Action getAction();
}
