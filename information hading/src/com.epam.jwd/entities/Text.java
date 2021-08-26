package com.epam.jwd.entities;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextElement {
    public List<TextElement> textElements = new ArrayList<>();

    public void add(TextElement textElement) {
        textElements.add(textElement);
    }

    public void remove(TextElement textElement) {
        textElements.remove(textElement);
    }

    @Override
    public String toString() {
        return "Text{" + "textElements=" + textElements + '}';
    }
}
