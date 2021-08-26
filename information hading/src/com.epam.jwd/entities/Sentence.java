package com.epam.jwd.entities;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextElement {
    public List<TextElement> sentenceElements = new ArrayList<>();

    public void add(TextElement sentenceElement) {
        sentenceElements.add(sentenceElement);
    }

    public void remove(TextElement sentenceElement) {
        sentenceElements.remove(sentenceElement);
    }

    @Override
    public String toString() {
        return "Sentence{" + "sentenceElements=" + sentenceElements + '}';
    }
}
