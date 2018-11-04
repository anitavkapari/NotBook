package com.example.dell.notebook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.dell.notebook.DB.DBHolder;
import com.example.dell.notebook.DB.Notes;
import com.example.dell.notebook.adapter.NoteListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    RecyclerView rvNote;
    EditText edtTitle, edtNotes;
    NoteListAdapter adapter;
    private Notes[] notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        edtTitle.findViewById(R.id.edtTitle);
//        edtNotes.findViewById(R.id.edtNotes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvNote = findViewById(R.id.rvNote);
        rvNote.setLayoutManager(new LinearLayoutManager(this));//
        DBHolder dbholder = new DBHolder(this);//
        List<Notes> notes = dbholder.getAllNote();
        NoteListAdapter adapter = new NoteListAdapter(notes, dbholder);
        rvNote.setAdapter(adapter);




        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.item2);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:

                return true;

        }
                return super.onOptionsItemSelected(item);
        }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList <Notes> arrayList = new ArrayList<>();
        for (Notes note: notes){
            String title = note.getTitle().toLowerCase();
            if (title.contains(newText))
                arrayList.add(note);
        }
        adapter.setFilter(arrayList);
        return true;
    }
}
