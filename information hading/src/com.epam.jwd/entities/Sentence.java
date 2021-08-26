package com.epam.jwd.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence implements TextElement {
    private static final String SPACE = " ";
    public List<TextElement> sentenceElements = new ArrayList<>();

    public void add(TextElement sentenceElement) {
        sentenceElements.add(sentenceElement);
    }

    public void remove(TextElement sentenceElement) {
        sentenceElements.remove(sentenceElement);
    }

    public List<TextElement> getSentenceElements() {
        return sentenceElements;
    }

    public List<TextElement> getWord() {
        return sentenceElements.stream()
                .filter(word -> word instanceof Word)
                .collect(Collectors.toList());
    }

    @Override
    public void print() {
        sentenceElements.forEach(TextElement::print);
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        sentenceElements.forEach(element -> sentence
                .append(element.toString())
                .append(SPACE));
        return sentence.toString();
    }
}
