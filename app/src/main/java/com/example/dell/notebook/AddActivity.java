package com.example.dell.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.notebook.DB.DBHolder;
import com.example.dell.notebook.DB.Notes;

public class AddActivity extends AppCompatActivity {
EditText edtTitle,edtNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtTitle=findViewById( R.id.edtTitle );
        edtNotes=findViewById( R.id.edtNotes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            String title =edtTitle.getText().toString().trim();
            String note =edtNotes.getText().toString().trim();
            Notes notes = new Notes(id,title,note);
            DBHolder dBholder=new DBHolder(this);
            boolean isAddes= dBholder.addNote( notes );
            if(isAddes){
                Toast.makeText( this,"Recod Added",Toast.LENGTH_SHORT ).show();
            }
            Intent intent = new Intent(this ,MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
