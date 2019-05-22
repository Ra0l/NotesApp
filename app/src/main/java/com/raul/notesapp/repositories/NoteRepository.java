package com.raul.notesapp.repositories;

import com.orm.SugarRecord;
import com.raul.notesapp.models.Notes;

import java.util.List;

public class NoteRepository {

    public static void create(String title,String container,String date){

        Notes notes=new Notes();
        notes.setTitle(title);
        notes.setContainer(container);
        notes.setDate(date);

        SugarRecord.save(notes);

    }

    public static List<Notes> list() {
        List<Notes> notes=SugarRecord.listAll(Notes.class);
        return notes;
    }
}
