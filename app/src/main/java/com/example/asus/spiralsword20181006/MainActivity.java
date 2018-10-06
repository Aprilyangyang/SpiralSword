package com.example.asus.spiralsword20181006;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
//import android.service.autofill.FillEventHistory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import static com.example.asus.spiralsword20181006.R.layout.activity_main;
//import android.widget.ImageView;

/**
 *
 *
 * **/

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable anim;
    @SuppressLint("ClickableViewAccessibility")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
       LinearLayout rootLayout =findViewById(R.id.rootLayout);
       // FrameLayout frame =new FrameLayout(this);
        final MyView myview;
        myview = new MyView(this);
        Button button1= findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myview.setBackgroundResource(R.drawable.anim);
                myview.setVisibility(View.INVISIBLE);
               myview.invalidate();

            }
        });
        Button button2= findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myview.setBackgroundResource(R.drawable.luoxuanwan);
                myview.setVisibility(View.INVISIBLE);
                myview.invalidate();

            }
        });

        Button button3= findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myview.setBackgroundResource(R.drawable.qianniao);
                myview.setVisibility(View.INVISIBLE);
                myview.invalidate();

            }
        });
        myview.setBackgroundResource(R.drawable.qianniao);
        myview.setVisibility(View.INVISIBLE);
        anim=(AnimationDrawable)myview.getBackground();
        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    anim.stop();
                    float x=event.getX();
                    float y=event.getY();
                    myview.setLocation((int)y-40,(int) x-20);
                    myview.setVisibility(View.VISIBLE);
                    anim.start();
                }
                return false;
            }
        });



      //  frame.addView(myview);
        rootLayout.addView(myview);


    }


    class MyView extends android.support.v7.widget.AppCompatImageView{
        public  MyView(Context context){
            super(context);

        }
        public void setLocation(int top,int left){
            this.setFrame(left,top,left+40,top+40
            );

        }
    }
}
