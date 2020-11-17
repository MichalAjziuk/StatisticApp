package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class EditPlayer extends AppCompatActivity {

    private ListView pLista;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        pLista = findViewById(R.id.lista);


        DatabaseHelper db = new DatabaseHelper(EditPlayer.this);
        final List<String>everyone = db.getAllPlayers();
        arrayAdapter = new ArrayAdapter<>(EditPlayer.this, android.R.layout.simple_list_item_1, everyone);
        pLista.setAdapter(arrayAdapter);

        pLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EditPlayer.this, EditPlayerPanel.class);
                intent.putExtra(String.valueOf(everyone), pLista.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }
}