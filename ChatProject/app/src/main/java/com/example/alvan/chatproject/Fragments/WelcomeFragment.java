package com.example.alvan.chatproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alvan.chatproject.Activitis.LoginActivity;
import com.example.alvan.chatproject.Activitis.RegisterActivity;
import com.example.alvan.chatproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {
    private Button mSigninButton;
    private Button mGetStartedButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        mSigninButton = (Button) view.findViewById(R.id.FragmentWelcome_Signin_button);
        mGetStartedButton = (Button) view.findViewById(R.id.FragmentWelcome_Getstarted_button);

        mSigninButton.setOnClickListener(mSigninButtononClickListener);
        mGetStartedButton.setOnClickListener(mGetStartedButtononClickListener);

        return view;
    }

    private View.OnClickListener mSigninButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;

        }
    };

    private View.OnClickListener mGetStartedButtononClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), RegisterActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;
        }
    };
}
