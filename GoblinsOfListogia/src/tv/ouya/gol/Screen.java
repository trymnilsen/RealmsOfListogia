package tv.ouya.gol;

public abstract class Screen {
    protected final Game gameInstance;

    public Screen(Game game) {
        this.gameInstance = game;
    }

    public abstract void update(float deltaTime);

    public abstract void paint(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();
    
    public abstract void backButton();
}
