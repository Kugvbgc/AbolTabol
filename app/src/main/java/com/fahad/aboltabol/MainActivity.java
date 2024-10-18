package com.fahad.aboltabol;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Modiul 1 ________________
    CardView box, drawer;
    ImageView boxIcon;
    Animation open_drawer, close_drawer;

    // Modiul 2 ________________
    CardView horizontalDrawerBox, horizontalDrawer;
    ImageView horizontalDrawerBoxIcon;
    Animation open_horizontalDrawer, close_horizontalDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box = findViewById(R.id.box);
        drawer = findViewById(R.id.drawer);
        boxIcon = findViewById(R.id.boxIcon);

        open_drawer = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_drawer);
        close_drawer = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close_drawer);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = box.getTag().toString();
                if (tag.contains("close")) {
                    drawer.setVisibility(View.VISIBLE);
                    drawer.startAnimation(open_drawer);
                    boxIcon.setImageResource(R.drawable.down_arrow);
                    box.setTag("open");
                }
                if (tag.contains("open")) {
                    drawer.startAnimation(close_drawer);
                    drawer.setVisibility(View.GONE);
                    boxIcon.setImageResource(R.drawable.up_arrow);
                    box.setTag("close");
                }
            }
        });


        horizontalDrawerBox = findViewById(R.id.horizontalDrawerBox);
        horizontalDrawer = findViewById(R.id.horizontalDrawer);
        horizontalDrawerBoxIcon = findViewById(R.id.horizontalDrawerBoxIcon);

        open_horizontalDrawer = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open_horizontal_drawer);
        close_horizontalDrawer = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close_horizontal_drawer);

        horizontalDrawerBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = horizontalDrawerBox.getTag().toString();
                if (tag.contains("close")) {
                    horizontalDrawer.setVisibility(View.VISIBLE);
                    horizontalDrawer.startAnimation(open_horizontalDrawer);
                    horizontalDrawerBoxIcon.setImageResource(R.drawable.cross);
                    horizontalDrawerBox.setTag("open");
                }
                if (tag.contains("open")) {
                    horizontalDrawer.startAnimation(close_horizontalDrawer);
                    horizontalDrawer.setVisibility(View.GONE);
                    horizontalDrawerBoxIcon.setImageResource(R.drawable.dots);
                    horizontalDrawerBox.setTag("close");
                }
            }
        });

    }
}