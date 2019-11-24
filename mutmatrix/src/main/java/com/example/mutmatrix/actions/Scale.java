package com.example.mutmatrix.actions;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import static com.example.mutmatrix.Massages.MASSAGE;

public class Scale extends Base{

    private ScaleGestureDetector detector;

    public Scale(Context context) {
        super(context);
    }

    @Override
    public void reset() {
        detector = new ScaleGestureDetector(context,new ScaleListener());
    }

    @Override
    public Base touch(MotionEvent event) {
        int index = event.getActionIndex();
        int id = event.getPointerId(index);
        if(id==0||id==1)detector.onTouchEvent(event);
        return this;
    }

    @Override
    public void start(PointF p) {

    }

    @Override
    public void move(PointF p) {

    }

    @Override
    public void fin(PointF p) {

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        private float scale = 1.0f;

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            scale = rep.getScale();
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
            scale = rep.getScale();
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector){
            final float temp = rep.getScale();
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 10.0f));
            rep.setScale(scale);

            PointF f = new PointF(detector.getFocusX(),detector.getFocusY());
            PointF t = rep.getTranslate();

            float stepX = (f.x-t.x)*(rep.getScale()/temp);
            float stepY = (f.y-t.y)*(rep.getScale()/temp);

            rep.setTranslate(new PointF(f.x-stepX,f.y-stepY));
            return true;
        }
    }
}