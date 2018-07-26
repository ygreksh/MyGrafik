package com.example.ygrek.mygrafik;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.EditText;

public class Draw2D extends View {
    private Paint mPaint = new Paint();
    private Bitmap mBitmapSun;
    private Bitmap mBitmapMoon2;

    public Draw2D(Context context) {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();

        mBitmapMoon2 = BitmapFactory.decodeResource(res, R.drawable.moon3);
        mBitmapSun = BitmapFactory.decodeResource(res, R.drawable.sun);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int centerX = width/2;
        int centerY = height/2;

        //полярные координаты солнца и луны
        double polarSunAzi = 0;
        double polarSunAlt = 0;
        double polarMoonAzi = 0;
        double polarMoonAlt = 0;

        EditText editTextSunAzi = findViewById(R.id.editTextSunAzi);
        EditText editTextSunAlt = findViewById(R.id.editTextSunAlt);
        EditText editTextMoonAzi = findViewById(R.id.editTextMoonAzi);
        EditText editTextMoonAlt = findViewById(R.id.editTextMoonAlt);
        /*
        polarSunAzi = Double.parseDouble(String.valueOf(editTextSunAzi.getText()));
        polarSunAlt = Double.parseDouble(String.valueOf(editTextSunAlt.getText()));
        polarMoonAzi = Double.parseDouble(String.valueOf(editTextMoonAzi.getText()));
        polarMoonAlt = Double.parseDouble(String.valueOf(editTextMoonAlt.getText()));
        */
        polarSunAzi = 0;
        polarSunAlt = 20;
        polarMoonAzi = 45;
        polarMoonAlt = 60;

        //приведение к высоте над горизонтом и азимутом по часовой стрелке от направления на север
        polarSunAlt = 90 - polarSunAlt;
        polarSunAzi = polarSunAzi - 90;
        if (polarSunAzi < 0) polarSunAzi += 360;
        polarMoonAlt = 90 - polarMoonAlt;
        polarMoonAzi = polarMoonAzi - 90;
        if (polarMoonAzi < 0) polarMoonAzi += 360;


        //декартовы координаты солнца и луны, приведенные к области отображения
        double decSunX;
        double decSunY;
        double decMoonX;
        double decMoonY;
        decSunX = polarSunAlt * Math.cos(polarSunAzi*Math.PI/180);
        decSunY = polarSunAlt * Math.sin(polarSunAzi*Math.PI/180);
        decMoonX = polarMoonAlt * Math.cos(polarMoonAzi*Math.PI/180);
        decMoonY = polarMoonAlt * Math.sin(polarMoonAzi*Math.PI/180);


        int circle1Radius = (int) (width/2 - width*0.1/2);
        int circle2Radius = (int) (width/2 - width*0.2/2);
        int circle3Radius = (int) (width/2 - width*0.3/2);
        int circle4Radius = (int) (width/2 - width*0.4/2);
        int circle5Radius = (int) (width/2 - width*0.5/2);
        int circle6Radius = (int) (width/2 - width*0.6/2);
        int circle7Radius = (int) (width/2 - width*0.7/2);
        int circle8Radius = (int) (width/2 - width*0.8/2);
        int circle9Radius = (int) (width/2 - width*0.9/2);



        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL); //Сплошная заливка

        //концентрические круги
        mPaint.setStyle(Paint.Style.STROKE); //только контур
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(centerX, centerY, circle1Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle2Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle3Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle4Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle5Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle6Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle7Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle8Radius, mPaint);
        canvas.drawCircle(centerX, centerY, circle9Radius, mPaint);

        //линии север-юг и запад-восток
        canvas.drawLine(width/2, height/2 - width/2, width/2, height/2 + width/2, mPaint);
        canvas.drawLine(0, height/2, width, height/2, mPaint);
        // подписи сторон света
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        canvas.drawText("N", width/2-10, height/2 - width/2, mPaint);
        canvas.drawText("S", width/2-10, height/2 + width/2 +15, mPaint);
        canvas.drawText("W", 5, height/2 + 10, mPaint);
        canvas.drawText("E", width-20, height/2 + 10, mPaint);

        // Выводим изображение
        //canvas.drawBitmap(mBitmap, 450, 530, mPaint);

        //canvas.drawBitmap(mBitmapMoon2, moon2X, moon2Y, mPaint);
        float canvasSunX;
        float canvasSunY;
        float canvasMoonX;
        float canvasMoonY;

        canvasSunX = (float) (width/2 + decSunX/100*width/2 - mBitmapSun.getWidth()/2);
        canvasSunY = (float) (height/2 + decSunY/100*width/2 - mBitmapSun.getHeight()/2);
        canvasMoonX = (float) (width/2 + decMoonX/100*width/2 - mBitmapMoon2.getWidth()/2);
        canvasMoonY = (float) (height/2 + decMoonY/100*width/2 - mBitmapMoon2.getHeight()/2);

        canvas.drawBitmap(mBitmapSun, canvasSunX, canvasSunY, mPaint);
        canvas.drawBitmap(mBitmapMoon2, canvasMoonX, canvasMoonY, mPaint);
        /*
        //доги  координат

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        //canvas.drawText("Sun ("+ Double.toString(decSunX) + ", " + Double.toString(decSunY) +")", 10, 700, mPaint);
        //canvas.drawText("Moon ("+ Double.toString(decMoonX) + ", " + Double.toString(decMoonY) +")", 10, 730, mPaint);
        //canvas.drawText("Sun ("+ Double.toString(polarSunAzi) + ", " + Double.toString(polarSunAlt) +")", 10, 700, mPaint);
        //canvas.drawText("Moon ("+ Double.toString(polarMoonAzi) + ", " + Double.toString(polarMoonAlt) +")", 10, 730, mPaint);
*/
    }
}
