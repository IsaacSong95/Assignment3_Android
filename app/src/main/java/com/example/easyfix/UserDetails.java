package com.example.easyfix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserDetails extends AppCompatActivity {
    AppCompatEditText textInputEditTextEmail;
    private int[] images = {R.drawable.maintenance, R.drawable.brakes, R.drawable.engines,
            R.drawable.batteries, R.drawable.tires, R.drawable.steering,
            R.drawable.cooling, R.drawable.transmission};
    TextView textView;
    ProgressBar progressBar;
    GridView gridView;
    CustomAdapter customAdapter;
    Button buttonUserUpdate;
    Button buttonUserDelete;


    private List<UserModal> userModalList = new ArrayList<UserModal>();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        buttonUserUpdate = findViewById(R.id.ButtonUserUpdate);
        buttonUserDelete = findViewById(R.id.ButtonUser);
        textInputEditTextEmail = findViewById(R.id.UpdateEmail);
        DbHandler dbHandler = new DbHandler( UserDetails.this);
        ArrayList<HashMap<String, String>> userList =  dbHandler.getUsers();
//        for (int i = 0; i < userList.size(); i++) {
//
//            UserModal userModal = new UserModal(images[0], userList.get(i));
//            userModalList.add(userModal);

             // gridView = findViewById(R.id.gridview);

             //  customAdapter = new UserDetails.CustomAdapter(userModalList, this);

             //   gridView.setAdapter(customAdapter);

//        }
        buttonUserUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String username = intent.getStringExtra("username");
                Bundle bundleExtra = intent.getBundleExtra("bundle");
                bundleExtra.getString("username");
                DbHandler dbHandler = new DbHandler( UserDetails.this);
                String email = String.valueOf(textInputEditTextEmail.getText());
                int result = dbHandler.updateUser(username, email);
                System.out.println("result" + result);
            }
        });
        buttonUserDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String username = intent.getStringExtra("username");
                Bundle bundleExtra = intent.getBundleExtra("bundle");
                bundleExtra.getString("username");
                DbHandler dbHandler = new DbHandler( UserDetails.this);
                dbHandler.delete(username);
                System.out.println("delete");
            }
        });
    }
    public class CustomAdapter extends BaseAdapter {

        private List<UserModal> itemModalList;
        private Context context;

        public CustomAdapter(List<UserModal> itemModalList, Context context) {
            this.itemModalList = itemModalList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

}




