package com.example.mohamedabdelaziz.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        btn = (Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelItem modelItem = new ModelItem();
                modelItem.setName(tv1.getText().toString());
                modelItem.setEmail(tv2.getText().toString());
                modelItem.setPhone(tv3.getText().toString());
                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction(); //connect database only once at class
                try {
                    realm.copyToRealm(modelItem);  //try catch to avoid crash where primary key repeated
                    //this method required primary key in the opject
                } catch (Exception e) {
                }
                realm.commitTransaction();  //save and close connection
                List<ModelItem> modelItems = new ArrayList<>();  //list not array list
                modelItems = realm.allObjects(ModelItem.class);
                for (int i = 0; i < modelItems.size(); i++) {
                    Log.d("NAME", modelItems.get(i).getName());
                }

            }

        });


    }
}
