package com.example.tulips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tulips.model.Bulb;
import com.example.tulips.sample.SampleData;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get bulb id from the intent
        int bulbnum = (Integer)getIntent().getExtras().get("bulb_id");
        Bulb bulb = SampleData.tulipList.get(bulbnum);

        //populate image
        ImageView bulbImage = findViewById(R.id.imageViewBulb);
        bulbImage.setImageResource(bulb.getImageResourceID());

        //populate name
        TextView bulbName = findViewById(R.id.textViewName);
        bulbName.setText(bulb.getName());
    }
}
