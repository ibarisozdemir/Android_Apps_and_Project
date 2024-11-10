package com.baris.ybs_hafta_6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText my_edit_name;
    EditText my_edit_surname;
    EditText my_edit_Age;
    TextView my_txt_name;
    TextView my_txt_surname;
    TextView my_txt_age;


    SharedPreferences my_sp;




    @SuppressLint("WrongViewCast")
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

        my_txt_name = findViewById(R.id.textview);
        my_edit_name = findViewById(R.id.edittext_name);
        my_txt_surname = findViewById(R.id.textView4);
        my_edit_surname = findViewById(R.id.edittext_surname);
        my_txt_age = findViewById(R.id.textView5);
        my_edit_Age = findViewById(R.id.edittext_age);


        my_sp = getSharedPreferences("com.baris.ybs_hafta_6",Context.MODE_PRIVATE );
        loadData();


    }


    //@SuppressLint("SetTextI18n")
    private void loadData(){


        String user_name = my_sp.getString("userName","Name");
        String user_surname = my_sp.getString("userSurname","Surname");
        String user_age = my_sp.getString("userAge","Age");


        my_txt_name.setText("Your name is:   "+ user_name);
        my_txt_surname.setText("Your Surname is:   "+ user_surname);
        my_txt_age.setText("Your Age is:   "+ user_age);



        //my_txt_name.setText("Your name is:   "+ user_name);
    }
    //@SuppressLint("SetTextI18n")
    public void print_screen(View view){
        String user_name =my_edit_name.getText().toString();
        String user_surname =my_edit_surname.getText().toString();
        String user_age =my_edit_Age.getText().toString();

        int my_new_age =Integer.parseInt(user_age);

        SharedPreferences.Editor editor=my_sp.edit();
        editor.putString("userName",user_name);
        editor.putString("userSurame",user_surname);
        editor.putString("userAge",user_age);
        editor.apply();
        loadData();

    }
}