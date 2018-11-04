package com.example.dell.notebook.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dell.notebook.DB.DBHolder;
import com.example.dell.notebook.DB.Notes;
import com.example.dell.notebook.R;

import java.util.ArrayList;
import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder>{
 List<Notes> notes;
    DBHolder dbholder;
    public NoteListAdapter(List<Notes> notes, DBHolder dbholder) { //constructor
        this.notes = notes;
        this.dbholder = dbholder;

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.note_list,viewGroup,false  );
        return new NoteViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder studentViewHolder, int i) {
        final Notes note=notes.get( i );
        studentViewHolder .txttitle.setText( "Title :"+ note.getTitle() );
        studentViewHolder .txtNote.setText( "Note :"+ note.getNote() );

    }


    @Override
    public int getItemCount() {
            return notes.size();
        }

    public interface NoteAdapterListener {
        void onContactSelected(String title);

    }
    public  void  setFilter(ArrayList<Notes> newList){
        notes = new ArrayList<>();
        notes.addAll(newList);
        notifyDataSetChanged();
    }
}

