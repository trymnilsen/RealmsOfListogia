package tv.ouya.gol;

public interface Game {

    public Audio getAudio();

    //public Input getInput();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getInitScreen();
}