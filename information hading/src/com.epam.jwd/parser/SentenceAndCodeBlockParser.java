package com.epam.jwd.parser;

import com.epam.jwd.entities.CodeBlock;
import com.epam.jwd.entities.Sentence;
import com.epam.jwd.entities.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceAndCodeBlockParser extends Parser {
    private static final String REGEX_FOR_SENTENCE = "[A-Z][^\\.!?]*[\\.!?]";
    private static final String REGEX_CODE_BLOCK = "((^.+?\\{([\\s\\S]+?)^\\})|^.+=.+;|^\\S+;)";
    private static final String REGEX_SENTENCE_AND_CODE_BLOCK = "((^.+?\\{([\\s\\S]+?)^\\})|^.+=" +
            ".+;|^.+)";
    @Override
    public List<TextElement> getTextElement(String text) {
        Pattern sentenceAndCodeBlockPattern = Pattern.compile(REGEX_SENTENCE_AND_CODE_BLOCK,
                Pattern.MULTILINE);
        Matcher sentenceAndCodeBlockMatcher = sentenceAndCodeBlockPattern.matcher(text);

        List<TextElement> textElements = new ArrayList<>();

        while (sentenceAndCodeBlockMatcher.find()) {
            String textElement = text.substring(sentenceAndCodeBlockMatcher.start(),
                    sentenceAndCodeBlockMatcher.end());
            textElements.add(getTextElementByType(textElement));
        }
        return textElements;
    }

    private TextElement getTextElementByType(String textElement) {
        Pattern codeBlockPattern = Pattern.compile(REGEX_CODE_BLOCK, Pattern.MULTILINE);
        Matcher codeBlockMatcher = codeBlockPattern.matcher(textElement);

        if (codeBlockMatcher.find()) {
            return new CodeBlock(textElement);
        } else {
            Sentence sentence = new Sentence();
            getTextElementNext((textElement))
                    .forEach(sentence::add);
            return sentence;
        }
    }
}
