package com.example.dell.notebook.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dell.notebook.R;


public class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView txttitle,txtNote;


   // ImageButton btnDelete;


    public NoteViewHolder(@NonNull View itemView) {
        super( itemView );
        txttitle=itemView.findViewById(R.id.txttitle );
        txtNote=itemView.findViewById( R.id.txtNote );

    }
}
