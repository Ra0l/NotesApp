package com.raul.notesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raul.notesapp.R;
import com.raul.notesapp.repositories.NoteRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterNoteActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText conteinerInput;
    private Button buttonsaveContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_note);

        titleInput=findViewById(R.id.title_input);
        conteinerInput=findViewById(R.id.content_input);
        buttonsaveContainer=findViewById(R.id.register_button_content);
        buttonsaveContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }
    private void saveNote(){
        try{

            String titulo=titleInput.getText().toString();
            String contenido=conteinerInput.getText().toString();

            Date now = new Date();
            String date= new SimpleDateFormat("dd/MM/yyyy").format(now);

            if (titulo.isEmpty()||contenido.isEmpty()){
                Toast.makeText(this,"Complete los campos",Toast.LENGTH_SHORT).show();
                finish();
            }

            NoteRepository.create(titulo,contenido,date);
            Toast.makeText(this,"Registro de nota satisfactorio",Toast.LENGTH_SHORT).show();
            finish();


        }catch (Exception e){
            Log.e("RegisterNote", e.toString(), e);
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
