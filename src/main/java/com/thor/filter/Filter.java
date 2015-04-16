package com.thor.filter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.thor.filter.actions.Action;
import com.thor.filter.actions.CounterAction;
import com.thor.filter.actions.MatchCountAction;
import com.thor.filter.rules.FormRule;
import com.thor.filter.rules.JavacsriptRule;
import com.thor.filter.rules.LinkRule;
import com.thor.filter.rules.Rule;
import com.thor.filter.rules.StyleRule;

public class Filter {
    private static Rule[] DEFAULT_RULES = new Rule[]{LinkRule.INSTANCE_WITH_STRIP_TAG_ACTION, 
        FormRule.INSTANCE_WITH_STRIP_ALL_ACTION, 
        JavacsriptRule.INSTANCE_WITH_STRIP_ALL_ACTION, 
        StyleRule.INSTANCE_WITH_STRIP_ALL_ACTION};
    
    private final String htmlString;
    
    public Filter(String htmlString) {
        super();
        this.htmlString = htmlString;
    }

    public String filter(Rule... rules) {
        return filter(this.htmlString, rules);
    }
    
    public String filter() {
        return filter(this.htmlString, DEFAULT_RULES);
    }
    
    private String filter(String htlmString, Rule... rules) {
        Document document = Jsoup.parse(htlmString);
        for(Rule rule : rules) {
            Elements elements = rule.getElement(document);
            if(elements.isEmpty() == false) {
                Iterator<Element> iter = elements.iterator();
                while(iter.hasNext()) {
                    rule.getAction().apply(iter.next());
                }
            }
        }
        
        return document.html(); 
    }
    
    public static void main(String args[]) throws Exception{
    }
    
    
}
