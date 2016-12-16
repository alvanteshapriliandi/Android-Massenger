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

import com.example.alvan.chatproject.view.activitis.LoginActivity;
import com.example.alvan.chatproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private EditText mNameEditText;
    private EditText mUsernameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mRepasswordEditText;
    private EditText mQuestionEditText;
    private Button mRegisterButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        mNameEditText = (EditText) view.findViewById(R.id.FragmentRegister_name_edittext);
        mUsernameEditText = (EditText) view.findViewById(R.id.FragmentRegister_username_edittext);
        mEmailEditText = (EditText) view.findViewById(R.id.FragmentRegister_email_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.FragmentRegister_password_edittext);
        mRepasswordEditText = (EditText) view.findViewById(R.id.FragmentRegister_repassword_edittext);
        mQuestionEditText = (EditText) view.findViewById(R.id.FragmentRegister_question_edittext);
        mRegisterButton = (Button) view.findViewById(R.id.FragmentRegister_register_button);
        mRegisterButton.setOnClickListener(mRegisterButtononClickListener);
        return view;
    }

    private View.OnClickListener mRegisterButtononClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            String name = mNameEditText.getText().toString();
            if (name.isEmpty()){
                mNameEditText.setError(getString(R.string.empty_name_error));
                return;
            }
            String username = mUsernameEditText.getText().toString();
            if (username.isEmpty()){
                mUsernameEditText.setError(getString(R.string.empty_username_error));
                return;
            }
            String email = mEmailEditText.getText().toString();
            if (email.isEmpty()){
                mEmailEditText.setError(getString(R.string.empty_email_error));
                return;
            }
            String password = mPasswordEditText.getText().toString();
            if (password.isEmpty()){
                mPasswordEditText.setError(getString(R.string.empty_passwords_error));
                return;
            }
            String repassword= mRepasswordEditText.getText().toString();
            if (repassword.isEmpty()){
                mRepasswordEditText.setError(getString(R.string.empty_repassword_error));
                return;
            }
            String question = mQuestionEditText.getText().toString();
            if (question.isEmpty()){
                mQuestionEditText.setError(getString(R.string.empty_question_error));
                return;
            }

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;

            //Toast.makeText(getContext(), R.string.password_and_repassword_is_incorrect, Toast.LENGTH_SHORT).show();

        }
    };


}
