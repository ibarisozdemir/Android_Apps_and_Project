package com.baris.alternative;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView my_txt ;
    RadioButton my_rb1_ybs,my_rb2_bst;
    ImageView my_img_view;


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

        my_txt = findViewById(R.id.textView);
        my_rb1_ybs = findViewById(R.id.rb_ybs);
        my_rb2_bst= findViewById(R.id.rb_bst);
        my_img_view = findViewById(R.id.imageView);
    }

    public void clickybs(View view){
        if (my_rb1_ybs.isChecked()){
            my_rb2_bst.setChecked(false);
            my_txt.setTextColor(Color.parseColor("#FF0FEA2B"));
            my_txt.setText("Tebrikler! Başarılı bir tercih :  ");
            my_img_view.setImageResource(R.drawable.gta61);

        }
    }

    public void clickbts(View view){
        if (my_rb2_bst.isChecked()){
            my_rb1_ybs.setChecked(false);
            my_txt.setTextColor(Color.parseColor("#FF0000"));
            my_txt.setText("Maalesef Kötü Bit tercih :  ");
            my_img_view.setImageResource(R.drawable.gta62);

        }
    }
}