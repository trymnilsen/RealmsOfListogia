package tv.ouya.gol;

public class Vector2 {
	public int x;
	public int y;
	public Vector2(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public Vector2(Vector2 source)
	{
		this.x=source.x;
		this.y=source.y;
	}
	public Vector2 sub(Vector2 other)
	{
		this.x -=other.x;
		this.y -=other.y;
		return this;
	}

	public Vector2 add(Vector2 other)
	{
		this.x +=other.x;
		this.y +=other.y;
		return this;
	}
}
