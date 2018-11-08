package com.example.user.chemistry24.models;

public class TopicQuestion {

    private int _id;
    private String question;
    private String choice_a;
    private String choice_b;
    private String choice_c;
    private String choice_d;
    private String result;
    private int idTopic;
    public int typeQuestion;
    private String tem_ans= "";
    public int idChoice;

    public TopicQuestion(int _id, String question, String choice_a, String choice_b, String choice_c, String choice_d, String result, int idTopic, int typeQuestion, String tem_ans, int idChoice) {
        this._id = _id;
        this.question = question;
        this.choice_a = choice_a;
        this.choice_b = choice_b;
        this.choice_c = choice_c;
        this.choice_d = choice_d;
        this.result = result;
        this.idTopic = idTopic;
        this.typeQuestion = typeQuestion;
        this.tem_ans = tem_ans;
        this.idChoice = idChoice;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice_a() {
        return choice_a;
    }

    public void setChoice_a(String choice_a) {
        this.choice_a = choice_a;
    }

    public String getChoice_b() {
        return choice_b;
    }

    public void setChoice_b(String choice_b) {
        this.choice_b = choice_b;
    }

    public String getChoice_c() {
        return choice_c;
    }

    public void setChoice_c(String choice_c) {
        this.choice_c = choice_c;
    }

    public String getChoice_d() {
        return choice_d;
    }

    public void setChoice_d(String choice_d) {
        this.choice_d = choice_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(int typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTem_ans() {
        return tem_ans;
    }

    public void setTem_ans(String tem_ans) {
        this.tem_ans = tem_ans;
    }

    public int getIdChoice() {
        return idChoice;
    }

    public void setIdChoice(int idChoice) {
        this.idChoice = idChoice;
    }
}
