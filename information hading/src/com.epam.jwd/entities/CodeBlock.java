package com.epam.jwd.entities;

public class CodeBlock implements TextElement {
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
    public String toString() {
        return "CodeBlock{" + "codeBlock='" + codeBlock + '\'' + '}';
    }
}
