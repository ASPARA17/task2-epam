package com.epam.jwd.model;

import com.epam.jwd.entities.Text;
import com.epam.jwd.entities.TextElement;
import com.epam.jwd.parser.Parser;
import com.epam.jwd.parser.SentenceAndCodeBlockParser;
import com.epam.jwd.parser.SentenceElementsParser;
import com.epam.jwd.view.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    private final static String FILE_NAME = "text.txt";
    private List<TextElement> sentences = new ArrayList<>();
    private List<TextElement> words = new ArrayList<>();
    private Text text = new Text();

    private Parser getChainParsers() {
        return new SentenceAndCodeBlockParser()
                .linkWith(new SentenceElementsParser());
    }

    private void addParsingTextInClassText() {
        List<TextElement> list = getChainParsers()
                .getTextElement(FileReader.read(FILE_NAME));
        list.forEach(text::add);
    }

    private void getSentences() {
       sentences = text.getSentences();
    }

    public void print() {
        addParsingTextInClassText();
        text.print();
    }
    private void getWords() {

    }
}
