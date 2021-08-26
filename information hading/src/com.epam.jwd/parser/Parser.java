package com.epam.jwd.parser;

import com.epam.jwd.entities.TextElement;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {
    private Parser hasNext;
    private List<TextElement> textElementList = new ArrayList<>();

    public Parser getHasNext() {
        return hasNext;
    }

    public void setHasNext(Parser hasNext) {
        this.hasNext = hasNext;
    }

    public Parser linkWith(Parser hasNext) {
        this.hasNext = hasNext;
        return hasNext;
    }

    public abstract List<TextElement> getTextElement(String text);

    protected List<TextElement> getTextElementNext(String text) {
        if (hasNext == null) {
            return textElementList;
        }
        return hasNext.getTextElement(text);
    }

    @Override
    public String toString() {
        return "Parser{" + "hasNext=" + hasNext + '}';
    }
}
