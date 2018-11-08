package com.example.user.chemistry24;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.chemistry24.adapter.CheckTestListAdapter;
import com.example.user.chemistry24.controllers.ExcerciseController;
import com.example.user.chemistry24.controllers.TestController;
import com.example.user.chemistry24.models.TestQuestion;
import com.example.user.chemistry24.models.TopicQuestion;

import java.util.ArrayList;

public class TopicExerciseActivity extends AppCompatActivity {
    private ExcerciseController excerciseController;
    private ArrayList<TopicQuestion> questions;

    private static final int NUM_PAGES = 30;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Button btnTestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_exercise);

        Intent intent = getIntent();
        int exercise_id = intent.getIntExtra("exercise_id", 0);
        LinearLayout lyTiming = (LinearLayout) findViewById(R.id.lyTiming);
        lyTiming.setVisibility(View.GONE);

        Toast.makeText(this, "Lướt sang phải để xem câu hỏi tiếp theo", Toast.LENGTH_LONG).show();

        excerciseController = ExcerciseController.getInstance(this);
        excerciseController.open();
        questions = new ArrayList<TopicQuestion>();
        questions = excerciseController.getTopicQuestion(exercise_id);
        excerciseController.close();

        btnTestList = findViewById(R.id.btnTestList);
        btnTestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerList();
            }
        });

        mPager = (ViewPager) findViewById(R.id.topicpager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setPageTransformer(true, new DepthPageTransformer());
    }
        public ArrayList<TopicQuestion> getQuestions() {
        return questions;
    }

        public void checkAnswerList() {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_test_list);
            dialog.setTitle("Danh sách câu trả lời");

            CheckTestListAdapter adapter = new CheckTestListAdapter(questions,this);
            GridView gvTestList = dialog.findViewById(R.id.gvTestList);
            gvTestList.setAdapter(adapter);

            gvTestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mPager.setCurrentItem(position);
                    dialog.dismiss();
                }
            });

            Button btnTestClose, btnTestSubmit;
            btnTestClose = dialog.findViewById(R.id.btnTestClose);
            btnTestSubmit = dialog.findViewById(R.id.btnTestSubmit);

            btnTestClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btnTestSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ///
                }
            });

            dialog.show();
        }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setMessage("Bạn có muốn dừng thi?");
        builder.setCancelable(false);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TopicExerciseActivity.super.onBackPressed();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TopicFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
    }

