package com.company;

public enum Questions {

    QUESTION_1("Which is the highest mountain in the world?", "K2", "Everest", "Makalu", "Cho Oyu", "Everest"),
    QUESTION_2("How many planets are in the Solar System?", "7", "9", "8", "10", "8"),
    QUESTION_3("How many corners does a square have?", "3", "5", "2", "4", "4") {
    };

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String rightAnswer;

    Questions(String question, String answer1, String answer2, String answer3, String answer4, String rightAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.rightAnswer = rightAnswer;
    }

    public Questions getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer1() {
        return this.answer1;
    }

    public String getAnswer2() {
        return this.answer2;
    }

    public String getAnswer3() {
        return this.answer3;
    }

    public String getAnswer4() {
        return this.answer4;
    }

    public String getRightAnswer() {
        return this.rightAnswer;
    }
};
