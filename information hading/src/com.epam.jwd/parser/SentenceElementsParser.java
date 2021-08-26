package com.epam.jwd.parser;

import com.epam.jwd.entities.PunctuationMarks;
import com.epam.jwd.entities.TextElement;
import com.epam.jwd.entities.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceElementsParser extends Parser{
    private static final String REGEX_WORD = "\\w+";
    private static final String REGEX_PUNCTUATION_MARKS = "[.!?,:\\-]";
    private static final String REGEX_ELEMENTS_SENTENCE = "\\b";

    @Override
    public List<TextElement> getTextElement(String sentence) {
        List<TextElement> sentenceElements = new ArrayList<>();

        for (String element : sentence.split(REGEX_ELEMENTS_SENTENCE)) {
            if (!element.equals(" ")) {
                sentenceElements.add(getSentenceElementByType(element.trim()));
            }
        }
        return sentenceElements;
    }

    private TextElement getSentenceElementByType(String sentenceElement) {
        Pattern punctuationPattern = Pattern.compile(REGEX_PUNCTUATION_MARKS);
        Matcher punctuationMatcher = punctuationPattern.matcher(sentenceElement);

        if (punctuationMatcher.find()) {
            return new PunctuationMarks(sentenceElement);
        } else {
            return new Word(sentenceElement);
        }
    }
}
