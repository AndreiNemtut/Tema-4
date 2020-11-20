package com.company;

public enum Questions {

    QUESTION_1("Who is the main singer of the Guns N' Roses band?", "Axl Rose", "Duff McKagan", "Slash", "Dizzy Reed", "Axl Rose"),
    QUESTION_2("How many members were in the Queen band?", "3", "6", "4", "5", "4"),
    QUESTION_3("From which country does the band ABBA come?", "Norway", "Sweden", "Germany", "USA", "Sweden"),
    QUESTION_4("Which is the ABBA's best song?", "Fernando", "S.O.S.", "I Have A Dream", "Dancing Queen", "Dancing Queen"),
    QUESTION_5("Which is the Queen's best album?", "Greatest Hits", "A Kind Of Magic", "The Works", "A Night At The Opera", "Greatest Hits") {
    };

    private final String question;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final String answer4;
    private final String rightAnswer;

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
}
