package com.example.pc.myapplication.Model;

public class TopicQuestion {
    private int id;
    private String question;
    public boolean typeQuestion;
    private int topicID;

    public TopicQuestion( int id, String question, boolean typeQuestion, int topicID){
        this.id = id;
        this.question = question;
        this.typeQuestion = typeQuestion;
        this.topicID = topicID;
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicID() {
        return topicID;
    }
    public void setTopicID(int topicID){
        this.topicID = topicID;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question){
        this.question = question;
    }

    public boolean getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(boolean typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    @Override
    public String toString() {
        return "TopicQuestion{" +
                "topicID=" + topicID +
                ", id=" + id +
                ", question='" + question + '\'' +
                ", typeQuestion=" + typeQuestion +
                '}';
    }
}
