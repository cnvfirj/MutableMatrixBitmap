package com.example.mutmatrix;

import android.graphics.PointF;

public class Translate extends Base{

    private PointF start;

    private PointF fin;

    @Override
    public void reset() {
        start = null;
        fin = null;
    }

    @Override
    public void start(PointF p) {
        start = p;
    }

    @Override
    public void move(PointF p) {
        fin = p;
        calculateTranslate();
    }

    @Override
    public void fin(PointF p) {
        fin = p;
        calculateTranslate();
    }

    protected void calculateTranslate(){
        float x = fin.x-start.x;
        float y = fin.y-start.y;
        start = fin;
        final PointF t = rep.getTranslate();
        rep.setTranslate(new PointF(t.x+x,t.y+y));
    }
}
