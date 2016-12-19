package com.example.alvan.chatproject.view.fragments;


import android.content.Context;
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

import com.example.alvan.chatproject.view.activitis.MainActivity;
import com.example.alvan.chatproject.view.activitis.forgetActivity;
import com.example.alvan.chatproject.presenter.auth.LoginPresenter;
import com.example.alvan.chatproject.presenter.auth.LoginResponse ;
import com.example.alvan.chatproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginResponse{
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mSigninButton;
    private Button mForgetpPasswordButton;
    private LoginPresenter loginpresenter;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mUsernameEditText = (EditText) view.findViewById(R.id.FragmentLogin_username_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.FragmentLogin_password_edittext);
        mSigninButton = (Button) view.findViewById(R.id.FragmentLogin_signin_button);
        mForgetpPasswordButton = (Button) view.findViewById(R.id.FragmentLogin_forgetpassword_button);


        mSigninButton.setOnClickListener(mSigninButtononClickListener);
        mForgetpPasswordButton.setOnClickListener(mForgetPasswordButtononClickListener);
        loginpresenter = new LoginPresenter(this);
        context = getContext();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //berfungsi agar bisa di klik tombol sign in nya
    private View.OnClickListener mSigninButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = mUsernameEditText.getText().toString();
            if (username.isEmpty()){
                mUsernameEditText.setError(getString(R.string.empty_username_error));
                return;
            }

            String password = mPasswordEditText.getText().toString();
            if (username.isEmpty()){
                mPasswordEditText.setError(getString(R.string.empty_password_errors));
            }

            loginpresenter.doLogin(mUsernameEditText.getText().toString(), mPasswordEditText.getText().toString());

        }
    };


    private View.OnClickListener mForgetPasswordButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), forgetActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;
        }
    };

    public void doLoginSuccess(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void doLoginFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
