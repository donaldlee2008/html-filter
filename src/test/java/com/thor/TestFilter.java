package com.thor;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.thor.filter.Filter;
import com.thor.filter.actions.CounterAction;
import com.thor.filter.actions.MatchCountAction;
import com.thor.filter.rules.JavacsriptRule;
import com.thor.filter.rules.LinkRule;
import com.thor.filter.rules.Rule;

public class TestFilter {
    public String testString;
    
    @Before
    public void setup() throws Exception{
        testString = "<a href=\"#\">link 1</a><a href=\"#\">link 2</a><form method=\"post\"></form><script></script>";
        
    }
    
    @Test
    public void testCounterOnLinkAndScriptTag() {
        CounterAction counterAction = new MatchCountAction();
        new Filter(testString).filter(new Rule[]{new LinkRule(counterAction), new JavacsriptRule(counterAction)});
        assertEquals(3, counterAction.countMatches());
    }
    
    @Test
    public void testStripTag(){
        String result = new Filter(testString).filter(LinkRule.INSTANCE_WITH_STRIP_TAG_ACTION);
        assertFalse(StringUtils.contains(result, "<a"));
        assertTrue(StringUtils.contains(result, "link 1"));
    }
    
    @Test
    public void testDefaultFilters(){
        String result = new Filter(testString).filter();
        assertFalse(StringUtils.contains(result, "<form"));
        assertFalse(StringUtils.contains(result, "<a"));
        assertFalse(StringUtils.contains(result, "<script"));
    }
    
    
    /*
     * This method is to retrieve content of a web page.
     */
    private String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
    }

}
