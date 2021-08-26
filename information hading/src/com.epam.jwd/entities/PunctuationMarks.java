package com.epam.jwd.entities;

import com.epam.jwd.view.Output;

public class PunctuationMarks implements TextElement {
    private static final String SPACE = " ";
    private String sign;

    public PunctuationMarks(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public void print() {
        Output.output(getSign() + SPACE);
    }

    @Override
    public String toString() {
        return getSign();
    }

}
