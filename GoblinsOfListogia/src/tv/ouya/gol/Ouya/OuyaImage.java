package tv.ouya.gol.Ouya;

import tv.ouya.gol.Graphics.ImageFormat;
import tv.ouya.gol.Image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class OuyaImage implements Image {
    Bitmap bitmap;
    ImageFormat format;
    
    public OuyaImage(Bitmap bitmap)
    {
    	this.bitmap = bitmap;
    	
        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;
    }
    
    public OuyaImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}