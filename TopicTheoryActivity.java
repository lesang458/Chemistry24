package com.example.user.chemistry24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.chemistry24.controllers.TheoryController;
import com.example.user.chemistry24.models.TopicTheory;

public class TopicTheoryActivity extends AppCompatActivity {
    private TextView tvTopic;
    private TextView tvTheory;
    private TheoryController theoryController;
    private TopicTheory topicTheory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_theory);

        init();
        getWidgets();
        setWidgets();
        addListener();

    }

    private void init() {
        int idTopic= getIntent().getIntExtra("theory_id",0);
       theoryController= TheoryController.getInstance(this);
       theoryController.open();
       topicTheory = theoryController.getTopicTheory(idTopic);
       theoryController.close();
    }
    private void getWidgets() {
        tvTheory = findViewById(R.id.tvTheory);
        tvTopic = findViewById(R.id.tvTopic);

    }
    private void setWidgets() {
        tvTopic.setText(topicTheory.getTopicName());
        tvTheory.setText(topicTheory.getTopicData());
    }
    private void addListener() {
    }



}
