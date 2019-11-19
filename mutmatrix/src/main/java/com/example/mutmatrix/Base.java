package com.example.mutmatrix;

import android.graphics.PointF;

public abstract class Base {

    protected CompRep rep;

    public Base rep(CompRep rep){
        this.rep = rep;
        return this;
    }

    public void repCopy(CompRep rep){
        this.rep = rep.copy();
    }

    public CompRep getRep(){
        return rep;
    }

    public CompRep getRepCopy(){
        return rep.copy();
    }

    public abstract void reset();

    public abstract void start(PointF p);

    public abstract void move(PointF p);

    public abstract void fin(PointF p);


}
