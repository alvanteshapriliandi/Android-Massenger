package com.example.alvan.chatproject.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alvan.chatproject.view.activitis.ChangeActivity;
import com.example.alvan.chatproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForgetFragment extends Fragment {

    private EditText mQuestionEditText;
    private EditText mAnswerEditText;
    private Button mNextButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forget, container, false);

        mQuestionEditText = (EditText) view.findViewById(R.id.FragmentForget_question_edittext);
        mAnswerEditText = (EditText) view.findViewById(R.id.FragmentForget_answer_edittext);
        mNextButton = (Button) view.findViewById(R.id.FragmentForget_next_button);

        mNextButton.setOnClickListener(mNextButtononClickListener);

        return view;
    }

    private View.OnClickListener mNextButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), ChangeActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;

        }
    };
}
