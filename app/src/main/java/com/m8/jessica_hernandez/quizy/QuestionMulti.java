package com.m8.jessica_hernandez.quizy;

public class QuestionMulti {
    private String text;
    private Boolean answere;
    private int hint;

    public QuestionMulti(String text, Boolean answere, int hint) {
        this.text = text;
        this.answere = answere;
        this.hint = hint;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswere(Boolean answere) {
        this.answere = answere;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }

    public String getText() {
        return this.text;
    }

    public Boolean getAnswere() {
        return this.answere;
    }

    public int getHint() {
        return hint;
    }
}
