package com.example.chemistry24.models;

public class TestQuestion {

    private int idTest;
    private int idQuestion;
    private String question;
    private String answer;

    public TestQuestion(int idTest, int idQuestion, String question, String answer) {
        this.idTest = idTest;
        this.idQuestion = idQuestion;
        this.question = question;
        this.answer = answer;
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

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {

        this.question = question;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String answer) {

        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "idTest=" + idTest +
                ", idQuestion=" + idQuestion +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
