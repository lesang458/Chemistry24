package com.example.chemistry24.models;

public class TestChoice {

    private int idTest;
    private int idQuestion;
    private char idChoice;
    private String choice;
    private boolean check;

    public TestChoice(int idTest, int idQuestion, char idChoice, String choice, boolean check) {
        this.idTest = idTest;
        this.idQuestion = idQuestion;
        this.idChoice = idChoice;
        this.choice = choice;
        this.check = check;
    }

    public int getIdTest() {

        return idTest;
    }

    public void setIdTest(int idTest) {

        this.idTest = idTest;
    }

    public int getIdQuestion() {

        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {

        this.idQuestion = idQuestion;
    }

    public char getIdChoice() {

        return idChoice;
    }

    public void setIdChoice(char idChoice) {

        this.idChoice = idChoice;
    }

    public String getChoice() {

        return choice;
    }

    public void setChoice(String choice) {

        this.choice = choice;
    }

    public boolean isCheck() {

        return check;
    }

    public void setCheck(boolean check) {

        this.check = check;
    }

    @Override
    public String toString() {
        return "TestChoice{" +
                "idTest=" + idTest +
                ", idQuestion=" + idQuestion +
                ", idChoice=" + idChoice +
                ", choice='" + choice + '\'' +
                ", check=" + check +
                '}';
    }
}
