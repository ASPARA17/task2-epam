package com.epam.jwd.entities;

public class PunctuationMarks implements TextElement {
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
    public String toString() {
        return "PunctuationMarks{" + "sign='" + sign + '\'' + '}';
    }

}
