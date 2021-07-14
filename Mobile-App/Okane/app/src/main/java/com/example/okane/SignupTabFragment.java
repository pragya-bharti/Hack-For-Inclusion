package com.example.okane;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupTabFragment extends Fragment
{
    TextInputLayout mail,name,pass;
    Button signup;
    ProgressBar progressBar;
    int v= 0;
    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);
        bind(root);
        firebaseAuth = FirebaseAuth.getInstance();
        mail.setTranslationX(800);
        name.setTranslationX(800);
        pass.setTranslationX(800);

        mail.setAlpha(v);
        pass.setAlpha(v);
        name.setAlpha(v);

        mail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String mail_text = mail.getEditText().getText().toString().trim();
                String name_text = name.getEditText().getText().toString().trim();
                String pass_text = pass.getEditText().getText().toString().trim();
                progressBar.setVisibility(View.VISIBLE);
                registerUser(mail_text,name_text,pass_text);
            }
        });
        return root;

    }

    private void registerUser(String mail_text, String name_text, String pass_text)
    {
        firebaseAuth.createUserWithEmailAndPassword(mail_text,pass_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(getContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), MainActivity.class));

                }
                else
                {
                    Toast.makeText(getContext(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void bind(ViewGroup root)
    {
        mail = root.findViewById(R.id.email2);
        name = root.findViewById(R.id.name);
        signup = root.findViewById(R.id.signup_btn);
        pass = root.findViewById(R.id.pass2);
        progressBar = root.findViewById(R.id.register_progress);
    }
}
