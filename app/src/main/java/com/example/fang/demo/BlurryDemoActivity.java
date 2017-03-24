package com.example.fang.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import jp.wasabeef.blurry.Blurry;

public class BlurryDemoActivity extends AppCompatActivity {

    private ImageView imageView1;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blurry_demo);

        imageView1 = (ImageView) findViewById(R.id.iv_header_bg1);
        imageView = (ImageView) findViewById(R.id.iv_header_bg);

        Picasso.with(this).load("http://coc.weijie.so/img/content/000009580365.jpg").into(imageView1);

        new MyThread().start();
    }

    public class MyThread extends Thread {
        public void run() {
            try {
                Blurry.with(BlurryDemoActivity.this)
                        //半径
                        .radius(10)
                        //采样
                        .sampling(8)
                        //颜色
//                        .color(Color.argb(66, 255, 255, 0))
                        //异步
                        .async()
                        //动画
                        .animate(500)
                        .from(Picasso.with(BlurryDemoActivity.this).load("http://coc.weijie.so/img/content/000009580365.jpg").get())
                        .into(imageView);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
