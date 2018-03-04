package com.example.hp.calender112;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText date;
    //Date date;
    FirebaseDatabase mdatabase;
    DatabaseReference ref;
    user user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit);
        date = (EditText) findViewById(R.id.date);
        mdatabase = FirebaseDatabase.getInstance();
        ref = mdatabase.getReference("user");
        user = new user();

        submit.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                getValues();
                Intent myIntent = new Intent(MainActivity.this,
                        NewActivity.class);
                startActivity(myIntent);
            }
        });

    }

    private void getValues()
    {
        String Date = date.getText().toString().trim();
        Toast.makeText(this,Date.toString(), Toast.LENGTH_SHORT).show();
        if (!TextUtils.isEmpty(Date)) {

            String user2 = ref.push().getKey();
            Map user = new HashMap();
            user.put("user2",Date);
            ref.child(user2).setValue(user);
            Toast.makeText(this, "date inserted", Toast.LENGTH_LONG).show();
            /* startActivity(new Intent(MainActivity.this,New_Activity.class)); */
        } else {
            Toast.makeText(this, "you should enter a valid date", Toast.LENGTH_LONG).show();
        }


    }

   /* public void submit(View view){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getValues();
                ref.child("user1").setValue(user);
                Toast.makeText(MainActivity.this, "Date inserted successfully...", Toast.LENGTH_SHORT).show();


        })*/

    }

