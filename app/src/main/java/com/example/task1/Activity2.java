package com.example.task1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    //text to be toasted
    String[] countries = new String[] {
            "Apple",
            "Banana",
            "Orange",
            "Mango",
            "PineApple",
            "Guava",
            "Melon",
            "Strawberry",
            "BlueBerry",
            "Pomegranate",
            "Avacado",
            "Carrot",
            "Tomato",
            "Onion",
            "Garlic",



    };

    // Array of integers points to images stored in /res/drawable/

    int[] flags = new int[]{
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.orange,
            R.drawable.mango,
            R.drawable.pineapple,
            R.drawable.guava,
            R.drawable.melon,
            R.drawable.strawberry,
            R.drawable.blueberry,
            R.drawable.pomegranate,
            R.drawable.avacado,
            R.drawable.carrot,
            R.drawable.tomato,
            R.drawable.onion,
            R.drawable.garlic,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<15;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("flag", Integer.toString(flags[i]) );
            hm.put("txt", "Grocery : " + countries[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt" };

        // Ids of views in listlayout
        int[] to = { R.id.flag,R.id.textView1};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList , R.layout.listlayout, from, to);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                    long arg3) {
                //here v is ListItem's layout.
                TextView tv = (TextView) v.findViewById(R.id.textView1);
                Toast.makeText(getApplicationContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}