package com.example.tulips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.example.tulips.model.Character;
import com.example.tulips.sample.JSONData;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyListAdapter.ItemClickListener {
    List<Character> potterList=JSONData.characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get data
        if (potterList.isEmpty()) {
            potterList = JSONData.getJSON(this);
        }

        //get the recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //divider line between rows
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //define an adapter
        MyListAdapter adapter = new MyListAdapter(potterList, this, this);

        //assign the adapter to the recycler view
        recyclerView.setAdapter(adapter);

        //set a layout manager on the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        //opens web page in detail activity
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("id", position);

        //opens web page in browser
//        Intent intent = new Intent((Intent.ACTION_VIEW));
//        Character character = JSONData.characterList.get(position);
//        String webString = character.getInfo();
//        intent.setData(Uri.parse(webString));

        //starts new activity
        startActivity(intent);
    }
}
