package com.droidz_tutorial.jrepko.droidztutorial.model;

import com.droidz_tutorial.jrepko.droidztutorial.model.components.Speed;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Droid {
    private Bitmap bitmap;
    private int x;
    private int y;
    private boolean touched;
    private Speed speed;

    public Droid(Bitmap bitmap, int x, int y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.speed = new Speed();
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
    }

    public void update() {
        if (!touched) {
            x += (speed.getXv() * speed.getxDirection());
            y += (speed.getYv() * speed.getyDirection());
        }
    }

    public void handleActionDown(int eventX, int eventY) {
        if (eventX >= (x - bitmap.getWidth() / 2) && (eventX <= (x + bitmap.getWidth() /2))) {
            if (eventY >= (y - bitmap.getHeight() / 2) && (y <= (y + bitmap.getHeight() /2))) {
                setTouched(true);
            } else {
                setTouched(false);
            }
        } else {
            setTouched(false);
        }
    }
}