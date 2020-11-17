package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MatchesList extends AppCompatActivity {

    private ListView mList;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_list);

        Bundle bundle = new Bundle();
        mList = findViewById(R.id.matchesList);
        DatabaseHelper db = new DatabaseHelper(MatchesList.this);
        final List<Match_DV> allMatches = db.getAllMatches();
        arrayAdapter = new ArrayAdapter<>(MatchesList.this, android.R.layout.simple_list_item_1, allMatches);
        mList.setAdapter(arrayAdapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MatchesList.this, MatchPanel.class);
                intent.putExtra("id", i+1);
                startActivity(intent);
            }
        });
    }
}