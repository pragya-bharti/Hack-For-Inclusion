package com.example.okane;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFragment extends Fragment
{
    TextInputLayout email,pass;
    TextView forget_pass;
    Button login;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    int v=0;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);
        bind(root);

        firebaseAuth = FirebaseAuth.getInstance();
        email.setTranslationX(800);
        pass.setTranslationX(800);
        email.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        forget_pass.setAlpha(v);
        login.setAlpha(v);


        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forget_pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        //on pressing login button

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String mail_text = email.getEditText().getText().toString().trim();
                String pass_text = pass.getEditText().getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);
                if(TextUtils.isEmpty(mail_text))
                {
                    email.setError("Please provide an email");
                }
                else if(TextUtils.isEmpty(pass_text))
                {
                    pass.setError("Please enter password");
                }
                else
                {
                    loginUser(mail_text,pass_text);
                }
            }
        });
        return root;

    }

    private void loginUser(String mail_text, String pass_text)
    {
        firebaseAuth.signInWithEmailAndPassword(mail_text,pass_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(getContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Home.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getContext(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void bind(ViewGroup root)
    {
        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        forget_pass = root.findViewById(R.id.forget_pass);
        login = root.findViewById(R.id.login_btn);
        progressBar = root.findViewById(R.id.login_progress);
    }
}
