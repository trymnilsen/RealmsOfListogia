package tv.ouya.gol.Ouya;

import tv.ouya.gol.Graphics.ImageFormat;
import tv.ouya.gol.Image;

import android.graphics.Bitmap;

public class OuyaImage implements Image {
    Bitmap bitmap;
    ImageFormat format;
    
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