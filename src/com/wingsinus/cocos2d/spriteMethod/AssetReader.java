package com.wingsinus.cocos2d.spriteMethod;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class AssetReader {
   private static final String TAG = "AssetReader";
   
   public static String getStringFromAsset(Activity activity, String file) {
      String result = "";
      AssetManager assetManager = activity.getAssets();
      InputStream is = null;      
      try {
         is = assetManager.open(file);         
         result = convertStreamToString(is);               
      } catch(Exception e) {
         Log.d(TAG, e.getMessage());
      } finally {
         try {
            is.close();
         } catch(IOException e) {
            Log.d(TAG, e.getMessage());
         }
      }
      return result;
   }
   
   public static String convertStreamToString(InputStream is) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();      
      try {
         int i = is.read();
         while(i != -1) {
            baos.write(i);
            i = is.read();
         }   
      } catch(IOException e) {
         Log.d(TAG, e.getMessage());
      } finally {
         try {
            is.close();
         } catch(IOException e) {
            Log.d(TAG, e.getMessage());
         }
      }
      return baos.toString();
   }
}