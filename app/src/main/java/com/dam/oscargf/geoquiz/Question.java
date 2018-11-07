package com.dam.oscargf.geoquiz;

public class Question {
    private String text;
    private Boolean answere;
    private int hint;

    public Question(String text, Boolean answere, int hint) {
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
