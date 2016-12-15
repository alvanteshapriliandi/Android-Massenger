package com.example.alvan.chatproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.alvan.chatproject.Activitis.LoginActivity;
import com.example.alvan.chatproject.Activitis.forgetActivity;
import com.example.alvan.chatproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeFragment extends Fragment {

    private EditText mNewPasswordEditText;
    private EditText mNewRepasswordEditText;
    private Button mDoneButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change, container, false);

        mNewPasswordEditText = (EditText) view.findViewById(R.id.FragmentChange_newpassword_edittext);
        mNewRepasswordEditText = (EditText) view.findViewById(R.id.FragmentChange_newrepassword_edittext);
        mDoneButton = (Button) view.findViewById(R.id.FragmentChange_done_button);

        mDoneButton.setOnClickListener(mDoneButtononClickListener);
        return view;
    }

    private View.OnClickListener mDoneButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;

        }
    };
}
