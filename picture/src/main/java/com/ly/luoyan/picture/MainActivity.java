package com.ly.luoyan.picture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by luoyan on 16/6/12.
 */
public class MainActivity extends Activity {
    private ImageView imageView;
    private String url = "http://bmob-cdn-273.b0.upaiyun.com/2016/04/16/480a9b5340c8cfda807d2649ebba754d.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv);


    }
    public void transfer(View v){
        new MyAs().execute(url);
//        applyBlur();
    }
    private void applyBlur(Bitmap bitmap) {
        Log.d("sssstime", "start");
        long time = System.currentTimeMillis();
        Bitmap bitmap1 = bitmap.copy(Bitmap.Config.ARGB_8888,true);
        Bitmap result = FastBlur.doBlur(bitmap1,50,true);
        imageView.setImageBitmap(result);
        Log.d("sssstime", System.currentTimeMillis()-time+"     ");
        Log.d("sssstime", "end");
    }
//        View view = getWindow().getDecorView();
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache(true);
//        /**
//         * 获取当前窗口快照，相当于截屏
//         */
//        Bitmap bmp1 = view.getDrawingCache();
//        int height = getOtherHeight();
//        /**
//         * 除去状态栏和标题栏
//         */
//        Bitmap bmp2 = Bitmap.createBitmap(bmp1, 0, height,bmp1.getWidth(), bmp1.getHeight() - height);
//        blur(bmp2,view);
//    }
  class MyAs extends AsyncTask<String,Void,Bitmap>{

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.d("bmp123", params[0]);

            return ImageUtil.getBitmapFromUrl(params[0]);

    }

    @Override
    protected void onPostExecute(Bitmap bmp) {
        super.onPostExecute(bmp);
        Log.d("bmp123", String.valueOf(bmp==null));
        applyBlur(bmp);
//        imageView.setImageBitmap(bmp);
    }
}

}
