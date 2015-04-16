package com.thor.filter.actions;

import org.jsoup.nodes.Element;

public class MatchCountAction extends CounterAction {
    public int count;

    @Override
    public int countMatches() {
        // TODO Auto-generated method stub
        return count;
    }

    @Override
    public void apply(Element element) {
        // Assume always match, so count + 1;
        count += 1;
    }
}
