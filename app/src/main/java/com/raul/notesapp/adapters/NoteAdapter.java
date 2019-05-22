package com.raul.notesapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raul.notesapp.R;
import com.raul.notesapp.models.Notes;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private static final String TAG=NoteAdapter.class.getSimpleName();

    private AppCompatActivity activity;

    private List<Notes> notes;

    public NoteAdapter(AppCompatActivity activity){
        this.activity = activity;
        notes = new ArrayList<>();
    }

    public void setNotes(List<Notes>notes){

        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder viewHolder, int position) {
        final Notes notes1=this.notes.get(position);

        viewHolder.titleView.setText(notes1.getTitle());
        viewHolder.containerView.setText(notes1.getContainer());
        viewHolder.dateView.setText(notes1.getDate());




    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        private TextView titleView;
        private TextView containerView;
        private TextView dateView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleView=itemView.findViewById(R.id.title_text);
            containerView=itemView.findViewById(R.id.content_text);
            dateView=itemView.findViewById(R.id.date_text);

        }
    }
}
