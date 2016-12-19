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
import android.widget.Toast;
import android.content.Context;

import com.example.alvan.chatproject.view.activitis.LoginActivity;
import com.example.alvan.chatproject.R;
import com.example.alvan.chatproject.presenter.auth.RegisterPresenter;
import com.example.alvan.chatproject.presenter.auth.RegisterResponse;
import com.example.alvan.chatproject.view.activitis.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterResponse{


    private EditText mNameEditText;
    private EditText mUsernameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mRepasswordEditText;
    private EditText mQuestionEditText;
    private Button mRegisterButton;
    private RegisterPresenter registerpresenter;
    Context context;

    public RegisterFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        mUsernameEditText = (EditText) view.findViewById(R.id.FragmentRegister_username_edittext);
        mEmailEditText = (EditText) view.findViewById(R.id.FragmentRegister_email_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.FragmentRegister_password_edittext);
        mRepasswordEditText = (EditText) view.findViewById(R.id.FragmentRegister_repassword_edittext);
        mRegisterButton = (Button) view.findViewById(R.id.FragmentRegister_register_button);
        mRegisterButton.setOnClickListener(mRegisterButtononClickListener);

        context = getContext();
        registerpresenter = new RegisterPresenter(this);
        return view;
    }

    private View.OnClickListener mRegisterButtononClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
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


            registerpresenter.doRegister(mUsernameEditText.getText().toString(), mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());

            //Toast.makeText(getContext(), R.string.password_and_repassword_is_incorrect, Toast.LENGTH_SHORT).show();

        }
    };

    public void doRegisterSuccess(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void doRegisterFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
