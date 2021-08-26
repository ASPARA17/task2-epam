package com.epam.jwd.parser;

import com.epam.jwd.entities.CodeBlock;
import com.epam.jwd.entities.Sentence;
import com.epam.jwd.entities.TextElement;
import com.epam.jwd.view.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceAndCodeBlockParser extends Parser {
    private static final Logger logger = LogManager.getLogger(SentenceAndCodeBlockParser.class);
    private static final String START_PARSING = "Start text parsing";
    private static final String END_PARSING = "End text parsing";
    private static final String PARSING_CODE_BLOCK = "Parsing code block";
    private static final String START_PARSING_SENTENCE = "Start sentence parsing";
    private static final String END_PARSING_SENTENCE = "End sentence parsing";

    //private static final String REGEX_FOR_SENTENCE = "[A-Z][^\\.!?]*[\\.!?]";
    private static final String REGEX_CODE_BLOCK = "((^.+?\\{([\\s\\S]+?)^\\})|^.+=.+;|^\\S+;)";
    private static final String REGEX_SENTENCE_AND_CODE_BLOCK = "((^.+?\\{([\\s\\S]+?)^\\})|^.+=" +
            ".+;|^.+)";

    @Override
    public List<TextElement> getTextElement(String text) {
        logger.debug(START_PARSING);
        Pattern sentenceAndCodeBlockPattern = Pattern.compile(REGEX_SENTENCE_AND_CODE_BLOCK,
                Pattern.MULTILINE);
        Matcher sentenceAndCodeBlockMatcher = sentenceAndCodeBlockPattern.matcher(text);
        List<TextElement> TextElements = new ArrayList<>();

        while (sentenceAndCodeBlockMatcher.find()) {
            String TextElement = text.substring(sentenceAndCodeBlockMatcher.start(),
                    sentenceAndCodeBlockMatcher.end());
            TextElements.add(getTextElementByType(TextElement));
        }
        logger.debug(END_PARSING);
        return TextElements;
    }

    private TextElement getTextElementByType(String TextElement) {
        Pattern codeBlockPattern = Pattern.compile(REGEX_CODE_BLOCK, Pattern.MULTILINE);
        Matcher codeBlockMatcher = codeBlockPattern.matcher(TextElement);

        if (codeBlockMatcher.find()) {
            logger.debug(PARSING_CODE_BLOCK);
            return new CodeBlock(TextElement);
        } else {
            logger.debug(START_PARSING_SENTENCE);
            Sentence sentence = new Sentence();
            getTextElementNext((TextElement))
                    .forEach(sentence::add);
            logger.debug(END_PARSING_SENTENCE);
            return sentence;
        }
    }
}
