package com.example.ygrek.mygrafik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Draw2D draw2D = new Draw2D(this);
        //setContentView(draw2D);

        /*
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.mainLayout);

        // Добавляем новый ImageView
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.moon1);
        LinearLayout.LayoutParams imageViewLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(imageViewLayoutParams);

        mainLayout.addView(imageView);
        */

        //размещение графики и элементов управления на одном эеране
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        Draw2D draw2D = new Draw2D(this);
        mainLayout.addView(draw2D);
    }
}
