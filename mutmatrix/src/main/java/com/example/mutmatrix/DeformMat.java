package com.example.mutmatrix;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;

import static com.example.mutmatrix.Massages.ERROR;

public class DeformMat {

    public enum Command{
        TRANSLATE,
        SCALE_PLUS,
        SCALE_MINUS,
        SCALE_TOUCH,
        SCALE_VIEW,
        ROTATE,
        DEFORM,
        DEFORM_CONT,
        MIRROR,
        RESET,
        NULLABLE
    }

    private Base base, translate, scale, rotate, deform;

    private CompRep repository;

    private Command command;

    public Matrix matrix(Matrix matrix){
        if(matrix==null)matrix = new Matrix();
        matrix.reset();
        matrix.setPolyToPoly(repository.getSrc(),0,repository.getDst(),0,4);
        matrix.postScale(repository.getScale(),repository.getScale());
        matrix.postRotate(repository.getRotate());
        matrix.postTranslate(repository.getTranslate().x,repository.getTranslate().y);
        return matrix;
    }

    public DeformMat() {
        repository = new CompRep();
        translate = new Translate().rep(repository);
    }

    public DeformMat reset(){
        return this;
    }

    public DeformMat command(Command command){
        switch (command){
            case TRANSLATE:
                base = translate;
                break;
        }
        return this;
    }

    public DeformMat event(MotionEvent event){
        if(base!=null){
            int action = event.getAction();
            PointF p = new PointF(event.getX(),event.getY());
            switch (action){
                case MotionEvent.ACTION_DOWN:
                    base.start(p);
                    break;
                    case MotionEvent.ACTION_MOVE:
                        base.move(p);
                        break;
                        case MotionEvent.ACTION_UP:
                            base.fin(p);
                            break;
            }
        }else ERROR("base mutable null");
        return this;
    }

    public void setRepository(CompRep rep) {
        this.repository = rep;
        translate.rep(rep);
    }

    public CompRep getRepository(){
        return repository;
    }
}
