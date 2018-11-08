package com.example.user.chemistry24;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.user.chemistry24.models.TestQuestion;
import com.example.user.chemistry24.models.TopicQuestion;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    ArrayList<TopicQuestion> questions;
    public static final String PAGE = "page";
    private int mPageNum;

    TextView tvFragQuestionNum, tvFragQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;

    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_test,container,false);

        tvFragQuestionNum = rootView.findViewById(R.id.tvFragQuestionNum);
        tvFragQuestion = rootView.findViewById(R.id.tvFragQuestion);
        radA = rootView.findViewById(R.id.radA);
        radB = rootView.findViewById(R.id.radB);
        radC = rootView.findViewById(R.id.radC);
        radD = rootView.findViewById(R.id.radD);
        radioGroup = rootView.findViewById(R.id.radioGroup);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questions = new ArrayList<>();
        TopicExerciseActivity topicExerciseActivity = (TopicExerciseActivity) getActivity();
        questions = topicExerciseActivity.getQuestions();

        mPageNum = getArguments().getInt(PAGE);
    }

    public static TopicFragment create(int pageNum) {
        TopicFragment fragment = new TopicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE,pageNum);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final TopicQuestion item = questions.get(mPageNum);

        tvFragQuestionNum.setText("Câu "+(mPageNum+1));
        tvFragQuestion.setText(questions.get(mPageNum).getQuestion());
        radA.setText(item.getChoice_a());
        radB.setText(item.getChoice_b());
        radC.setText(item.getChoice_c());
        radD.setText(item.getChoice_d());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                item.idChoice = checkedId;
                item.setTempans(getChoiceFromId(checkedId));
            }
        });
    }

    private String getChoiceFromId(int id) {
        if(id == R.id.radA) return "A";
        if(id == R.id.radB) return "B";
        if(id == R.id.radC) return "C";
        if(id == R.id.radD) return "D";

        return "";
    }
}