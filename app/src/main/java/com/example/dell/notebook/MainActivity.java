package com.example.dell.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dell.notebook.DB.DBHolder;
import com.example.dell.notebook.DB.Notes;
import com.example.dell.notebook.adapter.NoteListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView rvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNote = findViewById(R.id.rvNote);
        rvNote.setLayoutManager( new LinearLayoutManager( this ) );//
        DBHolder dbholder=new DBHolder( this );//
        List<Notes> notes=dbholder.getAll();
        NoteListAdapter adapter=new NoteListAdapter(notes ,dbholder );
        rvNote.setAdapter( adapter );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Intent intent = new Intent(this ,AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
