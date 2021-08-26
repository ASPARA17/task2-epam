package com.epam.jwd.parser;

import com.epam.jwd.entities.PunctuationMarks;
import com.epam.jwd.entities.TextElement;
import com.epam.jwd.entities.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceElementsParser extends Parser{
    private static final Logger logger = LogManager.getLogger(SentenceElementsParser.class);
    private static final String START_PARSING = "Start sentence parsing";
    private static final String END_PARSING = "End text parsing";
    private static final String PARSING_PUNCTUATION = "Parsing punctuation marks";
    private static final String PARSING_WORD = "Parsing word";
    private static final String SPACE = " ";

    private static final String REGEX_PUNCTUATION_MARKS = "[.!?,:\\-]";
    private static final String REGEX_ELEMENTS_SENTENCE = "\\b";

    @Override
    public List<TextElement> getTextElement(String sentence) {
        logger.debug(START_PARSING);
        List<TextElement> sentenceElements = new ArrayList<>();

        for (String element : sentence.split(REGEX_ELEMENTS_SENTENCE)) {
            if (!element.equals(SPACE)) {
                sentenceElements.add(getSentenceElementByType(element.trim()));
            }
        }
        logger.debug(END_PARSING);
        return sentenceElements;
    }

    private TextElement getSentenceElementByType(String sentenceElement) {
        Pattern punctuationPattern = Pattern.compile(REGEX_PUNCTUATION_MARKS);
        Matcher punctuationMatcher = punctuationPattern.matcher(sentenceElement);

        if (punctuationMatcher.find()) {
            logger.debug(PARSING_PUNCTUATION);
            return new PunctuationMarks(sentenceElement);
        } else {
            logger.debug(PARSING_WORD);
            return new Word(sentenceElement);
        }
    }
}
