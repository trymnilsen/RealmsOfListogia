package tv.ouya.gol;

import tv.ouya.gol.Graphics.ImageFormat;


public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}