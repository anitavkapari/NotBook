package com.example.dell.notebook.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHolder  extends SQLiteOpenHelper{
    private static final String DB_NAME = "notebook.sqlite";  //made constant
    private static final int DB_VERSION = 1;
    private static final String TABLE = "notebook";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String NOTE = "note";

    public DBHolder(Context context) {

        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " create table " + TABLE
                +  "  ( " + ID + " integer primary key autoincrement , "
                + NOTE + " text ,  " + TITLE  + " text  )";
        Log.e( " DBQuery " , "==========" + query );
        sqLiteDatabase.execSQL( query );
    }
    public boolean addNote(Notes notes) {//database get
        SQLiteDatabase db = getWritableDatabase( );
        ContentValues values = new ContentValues( );
        values.put( TITLE, notes.getTitle( ) );
        values.put( NOTE, notes.getNote( ) );
        long no = db.insert( TABLE, null, values );
        if (no == 0) {
            return false;
        } else {
            return true;
        }
    }
    public List<Notes> getAll() {
        List<Notes> notes = new ArrayList<>( );
        SQLiteDatabase db = getReadableDatabase( );

        String query = "select * from " + TABLE;
        Cursor cursor = db.rawQuery( query, null );
        while (cursor.moveToNext( )) {
            int id = cursor.getInt( cursor.getColumnIndex( ID ) );
            String title = cursor.getString( cursor.getColumnIndex( TITLE ) );
            String note = cursor.getString( cursor.getColumnIndex( NOTE ) );
            Notes note1 = new Notes(id,title,note);
            note1.setId(id);
            notes.add(note1);
        }
        if (cursor != null && !cursor.isClosed( )) {
            cursor.close( );
        }
        db.close();
        return notes;
        }
   /* public boolean deleateStudent(int id) {
        SQLiteDatabase db = getWritableDatabase( );
        long row = db.delete( TABLE, ID + " = "+id, null );
        if (row > 0) {
            return true;
        } else {
            return false;
        }

    }
    public boolean updateStudent(Notes student , int id) {//database get
        SQLiteDatabase db = getWritableDatabase( );
        ContentValues values = new ContentValues( );
        values.put( NAME, student.getName( ) );
        values.put( ADDRESS, student.getAddress( ) );
        values.put( PHONE, student.getPhone( ) );
        long no = db.update( TABLE,  values, ID + " = "+id, null );
        db.close();
        if (no == 0) {
            return false;
        } else {
            return true;
        }
    }


    public Notes getStudent(String name)
    {
        Notes student=null;
        SQLiteDatabase db= getReadableDatabase();
        String query= "select * from "+TABLE+ " where "+NAME+ "='"+name+"'";
        Cursor cursor= db.rawQuery( query,null );

        if (cursor.moveToFirst()){
            int id = cursor.getInt( cursor.getColumnIndex( ID ) );
            String address = cursor.getString( cursor.getColumnIndex( ADDRESS ) );
            String phone = cursor.getString( cursor.getColumnIndex( PHONE ) );
            student = new Notes(name,address,phone);
            student.setId(id);
        }
        return  student;
    }*/
   @Override
   public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

   }
}



