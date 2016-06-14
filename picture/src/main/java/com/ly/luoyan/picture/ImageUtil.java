package com.ly.luoyan.picture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luoyan on 16/6/12.
 */
public class ImageUtil {

    public static Bitmap getBitmapFromUrl(String urlString) {
        Bitmap bitmap;
        InputStream is = null ;
        try
        {
            URL url=new URL(urlString);

            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            is=new BufferedInputStream(connection.getInputStream());
            bitmap=BitmapFactory.decodeStream(is);
            connection.disconnect();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {}
            return bitmap;
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }finally{
            try
            {
                is.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
