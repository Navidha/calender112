package com.example.hp.calender112;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity {

    private   ListView listView;
    String datE;
    private DatabaseReference databaseReference;
    List<user> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        listView = (ListView) findViewById( R.id.list1 );

        databaseReference= FirebaseDatabase.getInstance().getReference("user");
        list = new ArrayList<>();
    }
    @Override
    protected void onStart(){
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    list.clear();
                    for (DataSnapshot all_data : dataSnapshot.getChildren()) {
                        if (all_data != null)
                            Toast.makeText(NewActivity.this, "NULL", Toast.LENGTH_SHORT).show();

                        user uu = all_data.getValue(user.class);
                        if(uu.getUser2()!= null){
                            list.add(uu);
                        }
                       // Toast.makeText(NewActivity.this, "values"+ ), Toast.LENGTH_SHORT).show();

                    }
                    userAdapter uAdapter = new userAdapter(NewActivity.this, list);
                    listView.setAdapter(uAdapter);
                }
                catch(Exception e) {

                }

           }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
}
}
