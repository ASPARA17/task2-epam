package com.epam.jwd.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Text implements TextElement {
    private final String SPACE = " ";
    public List<TextElement> textElements = new ArrayList<>();

    public void add(TextElement textElement) {
        textElements.add(textElement);
    }

    public void remove(TextElement textElement) {
        textElements.remove(textElement);
    }

    public List<TextElement> getSentences() {
        return textElements.stream()
                .filter(sentence -> sentence instanceof Sentence)
                .collect(Collectors.toList());
    }

    @Override
    public void print() {
        textElements.forEach(TextElement::print);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        textElements.forEach(element -> text
                .append(element.toString())
                .append(SPACE));
        return text.toString();
    }
}
