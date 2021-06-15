package com.example.easyfix;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GriditemActivity extends AppCompatActivity {
    TextView name;
    ImageView image;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        name=findViewById(R.id.textViewGridName);
        image=findViewById(R.id.imageViewData);
        description=findViewById(R.id.textViewGridDescription);
        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));
        description.setText(intent.getStringExtra("description"));
    }
}
