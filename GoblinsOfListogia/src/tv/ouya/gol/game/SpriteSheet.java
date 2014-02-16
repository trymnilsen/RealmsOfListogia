package tv.ouya.gol.game;

import tv.ouya.gol.Image;

public class SpriteSheet {
	public int frames;
	Image sprite;
	int frameX;
	int frameY;
	int frameWidth;
	int frameHeight;
	int framesHorz;
	int framesVert;
	int currentFrame;
	public SpriteSheet(Image sprite, int frames, int framesPerLine){
		this.sprite = sprite;
		this.frames = frames;
		
		this.framesHorz = framesPerLine;
		this.framesVert = frames/framesPerLine;
		
		this.frameWidth = sprite.getWidth()/framesPerLine;
		this.frameHeight = sprite.getHeight()/framesVert;
		
		this.currentFrame = 0;
	}
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	public void setCurrentFrame(int frame)
	{
		currentFrame=frame;
	}
	public void nextFrame()
	{
		if(currentFrame>=frames)
		{
			currentFrame = 0;
		}
		else
		{
			currentFrame++;
		}
	}
	public int getFrames() {
		return frames;
	}
	public void setFrames(int frames) {
		this.frames = frames;
	}
	public Image getSprite() {
		return sprite;
	}
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	public int getFrameX() {
		frameX = frameWidth*(currentFrame%framesHorz);
		return frameX;
	}
	public int getFrameY() {
		frameY = frameHeight*(currentFrame/framesHorz);
		return frameY;
	}
	public int getFrameWidth() {
		return frameWidth;
	}
	public int getFrameHeight() {
		return frameHeight;
	}
	public int getFrameHorz() {
		return framesHorz;
	}
	public int getFramesVert() {
		return framesVert;
	}

}
