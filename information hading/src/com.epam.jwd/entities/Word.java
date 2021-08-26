package com.epam.jwd.entities;

public class Word implements TextElement {
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
    public String toString() {
        return "Word{" + "word='" + word + '\'' + '}';
    }
}
