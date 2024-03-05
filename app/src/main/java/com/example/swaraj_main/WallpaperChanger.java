package com.example.swaraj_main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WallpaperChanger extends AppCompatActivity {

    ImageButton imgBtn;

    EditText url,phone,location;

    Button search,dial,searchLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper);

        imgBtn = findViewById(R.id.wallpaperBtn);

        dial = findViewById(R.id.dial);

        location = findViewById(R.id.location);

        url = findViewById(R.id.url);

        phone = findViewById(R.id.phone);

        search = findViewById(R.id.search);

        searchLoc = findViewById(R.id.searchLoc);

        imgBtn.setOnClickListener(v->{
            Intent changeWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
            startActivity(Intent.createChooser(changeWallpaper,"Select Wallpaper"));
        });

        search.setOnClickListener(v->{
//            Intent web = new Intent(Intent.ACTION_VIEW);
//            web.setData(Uri.parse(String.format("https://google.com/search?q=%s",url.getText().toString())));
//            startActivity(web)
        });

        dial.setOnClickListener(v->{
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:"+phone.getText().toString()));
            startActivity(call);
        });

        searchLoc.setOnClickListener(v->{
            Intent loc = new Intent(Intent.ACTION_VIEW);
            loc.setData(Uri.parse(String.format("https://www.google.com/maps/place/%s",location.getText().toString())));
            startActivity(loc);
        });
    }
}
