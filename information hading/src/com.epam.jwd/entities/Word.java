package com.epam.jwd.entities;

import com.epam.jwd.view.Output;

public class Word implements TextElement {
    private static final String SPACE = " ";
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public void print() {
        Output.output(getWord() + SPACE);
    }

    @Override
    public String toString() {
        return getWord();
    }
}
