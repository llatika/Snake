package com.Snake;

public class Star {
    private int xStar;
    private int yStar;

    public Star(int y, int x){
        this.xStar=x;
        this.yStar=y;
    }

    public int getStarX()
    {
        return xStar;
    }
    public int getStarY()
    {
        return yStar;
    }
    public void setStarX(int x)
    {
        xStar=x;
    }
    public void setStarY(int y)
    {
        yStar=y;
    }
}
