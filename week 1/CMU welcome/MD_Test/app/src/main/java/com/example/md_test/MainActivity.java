package com.example.md_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private TextView message;
    private ImageView image;
    private Button button;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        message = findViewById(R.id.textView2);
        image = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        //listener
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome();
            }
        };

        //add listener to button
        button.setOnClickListener(onClickListener);
    }

    protected void welcome(){
        name = nameEditText.getText().toString();
        if (name.isEmpty() == false) {
            message.setText("Welcome to CMU, " + name + "!");
            image.setImageResource(R.drawable.cmuscottydog);
        } else {
            //source: https://stackoverflow.com/questions/6643432/remove-the-image-from-a-imageview-android
            image.setImageDrawable(null);
            message.setText(" ");

            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please enter your name";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (name != null) {
            outState.putString("username", name);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString("username");
        if (name != null && name.isEmpty() == false) {
            welcome();
        }
    }

}
