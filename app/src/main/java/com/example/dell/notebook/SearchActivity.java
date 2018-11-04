package com.example.dell.notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.notebook.DB.DBHolder;
import com.example.dell.notebook.DB.Notes;

public class SearchActivity extends AppCompatActivity {
  //  EditText edtTitle,edtNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  edtTitle.findViewById(R.id.edtTitle);
       // edtNotes.findViewById(R.id.edtNotes);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.example_menu,menu);
            return true;
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                return true;
            /*case R.id.item2:
                Intent i = new Intent(this, AddActivity.class);
                startActivity(i);
                return true;
               *//* String title = edtTitle.getText( ).toString( ).trim( );
                if (TextUtils.isEmpty( title )) {
                    Toast.makeText( this, "please enter title to search ", Toast.LENGTH_SHORT ).show( );
                }
                DBHolder dbHolder = new DBHolder( this );
                Notes note = dbHolder.getNote(title);
                if (note==null) {
                    Toast.makeText( this,"Student not found", Toast.LENGTH_SHORT ).show();
                }
                else {
                    edtNotes.setText( note.getNote() );
                    int id = note.getId();
                    //spCourse.( employee.getCourse() );


                }
                return true;
            default:
        }*/
        }
        return super.onOptionsItemSelected(item);
    }
}
