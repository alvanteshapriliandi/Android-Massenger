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
import android.widget.Toast;

import com.example.alvan.chatproject.Activitis.MainActivity;
import com.example.alvan.chatproject.Activitis.forgetActivity;
import com.example.alvan.chatproject.Adapter.LoginAPI;
import com.example.alvan.chatproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mSigninButton;
    private Button mForgetpPasswordButton;
    private LoginAPI mLoginAPI;

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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginAPI = new LoginAPI();
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

            if(mLoginAPI.authenticate(username,password))
            {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                return;
            }


            Toast.makeText(getContext(), R.string.username_or_password_is_incorrects, Toast.LENGTH_SHORT).show();

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
}
