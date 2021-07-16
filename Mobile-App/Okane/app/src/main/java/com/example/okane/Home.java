package com.example.okane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> userlist;
    Button quizbtn,marketbtn,websitebtn,walletbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerview);
        userlist= new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        bind();
        userlist.add(new Item(R.drawable.imageone));
        userlist.add(new Item(R.drawable.imagetwo));
        userlist.add(new Item(R.drawable.imagethree));
        userlist.add(new Item(R.drawable.imagefour));
        CustomRecyclerAdapter customRecyclerAdapter = new CustomRecyclerAdapter(userlist,getApplicationContext());
        recyclerView.setAdapter(customRecyclerAdapter);

        marketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,MainActivity.class));
            }
        });

        walletbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,WalletView.class));
            }
        });

        websitebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,WebsiteView.class));
            }
        });

        quizbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,QuizView.class));
            }
        });
    }

    private void bind()
    {
        quizbtn = findViewById(R.id.quizbtn);
        marketbtn = findViewById(R.id.trackmarketbtn);
        websitebtn = findViewById(R.id.website_btn);
        walletbtn = findViewById(R.id.walletbtn);
    }
}