package com.baris.ybs4ahafta7;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit_id,edit_name,edit_age;
    TextView my_txt_id,my_txt_name,my_txt_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edit_id = findViewById(R.id.edittext_id);
        edit_name = findViewById(R.id.edittext_name);
        edit_age = findViewById(R.id.edittext_age);

        my_txt_id = findViewById(R.id.textview_id);
        my_txt_name = findViewById(R.id.textview_name);
        my_txt_age = findViewById(R.id.textview_age);

        Button btn_insert = findViewById(R.id.btn_insert);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_select = findViewById(R.id.btn_select);



        btn_insert.setOnClickListener(this::insertData);
        btn_update.setOnClickListener(this::updateData);
        btn_delete.setOnClickListener(this::deleteData);
        btn_select.setOnClickListener(this::selectData);

        SQLiteDatabase my_db =this.openOrCreateDatabase("LastStudents",MODE_PRIVATE,null);

        my_db.execSQL("CREATE TABLE IF NOT EXISTS Table_Students(student_id INTEGER PRIMARY KEY AUTOINCREMENT,student_name NVARCHAR,student_age INTEGER)");




    }

    private void insertData(View view){
        String s_name =edit_name.getText().toString();
        int s_age = Integer.parseInt(edit_age.getText().toString());
        SQLiteDatabase my_db =this.openOrCreateDatabase("LastStudents",MODE_PRIVATE,null);
        my_db.execSQL("INSERT INTO  Table_students(student_name,student_age)VALUES(?,?)",new Object[]{s_name,s_age});

    }
    private void updateData(View view){
        String s_name =edit_name.getText().toString();
        int s_age = Integer.parseInt(edit_age.getText().toString());
        int s_id = Integer.parseInt(edit_id.getText().toString());
        SQLiteDatabase my_db =this.openOrCreateDatabase("LastStudents",MODE_PRIVATE,null);

        my_db.execSQL("UPDATE Table_students SET student_name = ?,student_age = ? WHERE student_id=?",new Object[]{s_name,s_age,s_id});

    }
    private void deleteData(View view){

        int s_id = Integer.parseInt(edit_id.getText().toString());
        SQLiteDatabase my_db =this.openOrCreateDatabase("LastStudents",MODE_PRIVATE,null);

        my_db.execSQL("DELETE FROM Table_students  WHERE student_id=?",new Object[]{s_id});

    }
    private void selectData(View view){

        SQLiteDatabase my_db =this.openOrCreateDatabase("LastStudents",MODE_PRIVATE,null);
        Cursor my_cursor = my_db.rawQuery("SELECT * FROM Table_students",null);

        while(my_cursor.moveToNext()){

            @SuppressLint("Range") int my_id = my_cursor.getInt(my_cursor.getColumnIndex("student_id"));
            @SuppressLint("Range") String my_name = String.valueOf(my_cursor.getInt(my_cursor.getColumnIndex("student_name")));
            @SuppressLint("Range") int my_age = my_cursor.getInt(my_cursor.getColumnIndex("student_age"));


            System.out.println("Id = "+my_id);
            System.out.println("Name = "+my_name);
            System.out.println("Age= "+my_age);

            my_txt_id.setText("Id = "+my_id);
            my_txt_name.setText("Name = "+my_name);
            my_txt_age.setText("Age= "+my_age);

        }
        my_cursor.close();

    }
}