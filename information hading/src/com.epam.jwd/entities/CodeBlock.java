package com.epam.jwd.entities;

import com.epam.jwd.view.Output;

public class CodeBlock implements TextElement {
    private static final String SPACE = " ";
    private String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    @Override
    public void print() {
        Output.output(getCodeBlock() + SPACE);
    }

    @Override
    public String toString() {
        return getCodeBlock();
    }
}
