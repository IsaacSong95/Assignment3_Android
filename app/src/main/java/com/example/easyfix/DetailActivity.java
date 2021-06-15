package com.example.easyfix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    Intent intent;
    ListView lv;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        DbHandler db = new DbHandler(this);

        ArrayList<HashMap<String, String>>  userList = db.getUsers();

        lv=findViewById(R.id.user_list);
        ListAdapter adapter=new SimpleAdapter(DetailActivity.this,
                userList, R.layout.list_row,
                new String[]{"fullname", "username", "password", "email"},
                new int[]{R.id.fullname,R.id.username,R.id.password,R.id.email});
        lv.setAdapter(adapter);

        back=findViewById(R.id.btnBack);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intent=new Intent(DetailActivity.this,SignUp.class);
                startActivity(intent);

            }

        });



    }
}


