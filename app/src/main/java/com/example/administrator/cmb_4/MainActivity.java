package com.example.administrator.cmb_4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.ImageView;


public class MainActivity extends Activity {

    WebView webView;
    EditText editText;
    Button button,button_Scanner;
    ImageView mImageView;
    static final int REQUEST_IMAGE_CAPTURE = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }



    private void init(){
         button = (Button) findViewById(R.id.button);
         button_Scanner = (Button) findViewById(R.id.button1);
         editText = (EditText) findViewById(R.id.editText);
         webView = (WebView) findViewById(R.id.WebView1);
         mImageView = (ImageView) findViewById(R.id.ImageView) ;
         webView.getSettings().setJavaScriptEnabled(true);
         webView.setWebViewClient(new WebViewClient());
         webView.loadUrl("http://www.baidu.com");

         myclick_onserach();
         myclick_QrScanner();
    }

    private void myclick_onserach(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgurl = editText.getText().toString();
                webView.loadUrl(msgurl);
                //editText.setText("hello shili");
            }
        });
    }

    private void myclick_QrScanner(){
        button_Scanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);
            }
        });
    }



    private void startCameraCapture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       // if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
           startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
//            resultTv.setText(data.getStringExtra(CaptureActivity.EXTRA_RESULT));
//            resultIv.setImageBitmap((Bitmap)data.getParcelableExtra(CaptureActivity.EXTRA_BITMAP));
            String str_url= data.getStringExtra(CaptureActivity.EXTRA_RESULT);
            webView.loadUrl(str_url);

        } else {
//            resultTv.setText("");
//            resultIv.setImageDrawable(null);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 0 && resultCode == RESULT_OK) {
//            editText.setText(data.getStringExtra(CaptureActivity.EXTRA_RESULT));
//            mImageView.setImageBitmap((Bitmap)data.getParcelableExtra(CaptureActivity.EXTRA_BITMAP));
//        } else {
//            editText.setText("");
//            mImageView.setImageDrawable(null);
//        }
//    }

//        @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        //super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == REQUEST_IMAGE_CAPTURE &&  resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//
//
//
//            editText.setText(imageBitmap.toString());
//
//            mImageView.setImageBitmap(imageBitmap);
//
//        }
//    }


//    private  void myclick_search(){
//        // webView.loadUrl("http://http://www.ifeng.com/");
//        editText.setText("hello shili");
//    }


}
