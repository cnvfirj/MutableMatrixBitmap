package com.example.mutmatrix;


import android.graphics.PointF;
import android.graphics.RectF;

import java.io.Serializable;

import static com.example.mutmatrix.Massages.ERROR;

public class CompRep implements Serializable {

//    public static final int TOP_LEFT_X = 0;
//    public static final int TOP_LEFT_Y = 1;
//    public static final int TOP_RIGHT_X = 2;
//    public static final int TOP_RIGHT_Y = 3;
//    public static final int BOTTOM_RIGHT_X = 4;
//    public static final int BOTTOM_RIGHT_Y = 5;
//    public static final int BOTTOM_LEFT_X = 6;
//    public static final int BOTTOM_LEFT_Y = 7;

    public static final int P_X = 0;
    public static final int P_Y = 1;

    public static final int R_CENTER = 0;
    public static final int R_L_TOP = 1;
    public static final int R_R_TOP = 2;
    public static final int R_R_BOTTOM = 3;
    public static final int R_L_BOTTOM = 4;

    public static final int R_SIDE_TOP = 5;
    public static final int R_SIDE_RIGHT = 6;
    public static final int R_SIDE_BOTTOM = 7;
    public static final int R_SIDE_LEFT = 8;
    public static final int DEF_CENTER = 9;

    private float cTranslateX,cTranslateY;
    private float cStepX, cStepY;
    private float cScale;
    private float cRotate;
//    private float cDst_0,cDst_1,cDst_2,cDst_3,cDst_4,cDst_5,cDst_6,cDst_7;
//    private float cSrc_0,cSrc_1,cSrc_2,cSrc_3,cSrc_4,cSrc_5,cSrc_6,cSrc_7;
//    private float cInt_0,cInt_1,cInt_2,cInt_3,cInt_4,cInt_5,cInt_6,cInt_7;

    private float[]cDst, cSrc, cInt;

    private float cWidthImg, cHeightImg;

    private float[][]cLoc;

    CompRep() {
        reset();
    }

    public CompRep copy(){
        CompRep rep = new CompRep();
        rep.setBitmap(new PointF(cWidthImg,cHeightImg));
        rep.setTranslate(new PointF(cTranslateX,cTranslateY));
        rep.setScale(cScale);
        rep.setRotate(cRotate);
        rep.setStep(new PointF(cStepX,cStepY));
//        rep.setDst(new float[]{cDst_0,cDst_1,cDst_2,cDst_3,cDst_4,cDst_5,cDst_6,cDst_7});
//        rep.setSrc(new float[]{cSrc_0,cSrc_1,cSrc_2,cSrc_3,cSrc_4,cSrc_5,cSrc_6,cSrc_7});
//        rep.setInt(new float[]{cInt_0,cInt_1,cInt_2,cInt_3,cInt_4,cInt_5,cInt_6,cInt_7});
        rep.setDst(cDst);
        rep.setSrc(cSrc);
        rep.setInt(cInt);
        return rep;
    }

    public void reset(){
        cTranslateX = 0;
        cTranslateY = 0;
        cScale = 1;
        cRotate = 0;
        cStepX = 0;
        cStepY = 0;
        cLoc = new float[10][];
        cDst = new float[8];
        cSrc = new float[8];
        cInt = new float[8];

    }

    public void setTranslate(PointF cTranslate) {
        cTranslateX = cTranslate.x;
        cTranslateY = cTranslate.y;
    }

    public void setStep(PointF cStep){
        cStepX = cStep.x;
        cStepY = cStep.y;
    }

    public PointF getTranslate() {

        return new PointF(cTranslateX,cTranslateY);
    }

    public PointF getStep(){
        return new PointF(cStepX,cStepY);
    }

    public void setBitmap(PointF bitmap) {
        this.cWidthImg = bitmap.x;
        this.cHeightImg = bitmap.y;
    }

    public void setScale(float cScale) {
        this.cScale = cScale;
    }

    public void setRotate(float cRotate) {
        this.cRotate = cRotate;
    }

    public float getScale() {
        return cScale;
    }

    public float getRotate() {
        return cRotate;
    }

    public void setDst(float[] arr) {
//        cDst_0 = arr[0];
//        cDst_1 = arr[1];
//        cDst_2 = arr[2];
//        cDst_3 = arr[3];
//        cDst_4 = arr[4];
//        cDst_5 = arr[5];
//        cDst_6 = arr[6];
//        cDst_7 = arr[7];
        cDst[0] = arr[0];
        cDst[1] = arr[1];
        cDst[2] = arr[2];
        cDst[3] = arr[3];
        cDst[4] = arr[4];
        cDst[5] = arr[5];
        cDst[6] = arr[6];
        cDst[7] = arr[7];

    }
    public void setSrc(float[] arr) {
//        cSrc_0 = arr[0];
//        cSrc_1 = arr[1];
//        cSrc_2 = arr[2];
//        cSrc_3 = arr[3];
//        cSrc_4 = arr[4];
//        cSrc_5 = arr[5];
//        cSrc_6 = arr[6];
//        cSrc_7 = arr[7];
        cSrc[0] = arr[0];
        cSrc[1] = arr[1];
        cSrc[2] = arr[2];
        cSrc[3] = arr[3];
        cSrc[4] = arr[4];
        cSrc[5] = arr[5];
        cSrc[6] = arr[6];
        cSrc[7] = arr[7];
    }
    public void setInt(float[] arr) {
//        cInt_0 = arr[0];
//        cInt_1 = arr[1];
//        cInt_2 = arr[2];
//        cInt_3 = arr[3];
//        cInt_4 = arr[4];
//        cInt_5 = arr[5];
//        cInt_6 = arr[6];
//        cInt_7 = arr[7];
        cInt[0] = arr[0];
        cInt[1] = arr[1];
        cInt[2] = arr[2];
        cInt[3] = arr[3];
        cInt[4] = arr[4];
        cInt[5] = arr[5];
        cInt[6] = arr[6];
        cInt[7] = arr[7];
    }


    public RectF getDefaultLoc(){
        if(cHeightImg>0&&cWidthImg>0) {
            float width = cWidthImg * getScale();
            float height = cHeightImg * getScale();
            return new RectF(cTranslateX, cTranslateY, cTranslateX + width, cTranslateY + height);
        }
        ERROR("indefined bitmap");
        return null;
    }

    public void findLoc(){
        RectF bitmap = getDefaultLoc();
        if(bitmap!=null){
            float w =  bitmap.width();
            float h = bitmap.height();
            float diagonal = getPythagorasGip(w, h);
            float angleDiagonal = getAngleDiagonal(w, diagonal);

            cLoc[DEF_CENTER] = new float[]{bitmap.centerX(), bitmap.centerY()};
            cLoc[R_CENTER] = getPointAngle(diagonal / 2, angleDiagonal,1);
            cLoc[R_R_BOTTOM] = getPointAngle(diagonal, angleDiagonal,1);
            diagonal = getPythagorasGip(w,h/2);
            angleDiagonal = getAngleDiagonal(w,diagonal);
            cLoc[R_SIDE_RIGHT] = getPointAngle(diagonal,angleDiagonal,1);
            diagonal = getPythagorasGip(w/2,h);
            angleDiagonal = getAngleDiagonal(w/2,diagonal);
            cLoc[R_SIDE_BOTTOM] =getPointAngle(diagonal,angleDiagonal,1);
            cLoc[R_L_TOP] = new float[]{bitmap.left,bitmap.top};
            cLoc[R_R_TOP] = getPointAngle(bitmap.width(), 0,1);
            cLoc[R_SIDE_TOP] = getPointAngle(bitmap.width()/2, 0,1);
            cLoc[R_L_BOTTOM] = getPointAngle(bitmap.height(), 90,1);
            cLoc[R_SIDE_LEFT] = getPointAngle(bitmap.height()/2, 90,1);
        }else ERROR("not found loc");
    }

    public float[][]getLoc(){
        if(cLoc[R_CENTER]==null)findLoc();
        return cLoc;
    }

    public float[] getDst() {
//        return new float[]{cDst_0,cDst_1,cDst_2,cDst_3,cDst_4,cDst_5,cDst_6,cDst_7};
        return cDst;
    }

    public float[] getSrc() {
//        return new float[]{cSrc_0,cSrc_1,cSrc_2,cSrc_3,cSrc_4,cSrc_5,cSrc_6,cSrc_7};
        return cSrc;
    }

    public float[] getInt(){
        return cInt;
    }

    public PointF getBitmap(){
        return new PointF(cWidthImg,cHeightImg);
    }

    public float[] getPointAngle(float r, float angle, float scale){
        float newX = scale*(float)(r* Math.cos(Math.toRadians(cRotate+angle)))+cTranslateX;
        float newY = scale*(float)(r* Math.sin(Math.toRadians(cRotate+angle)))+cTranslateY;
        return new float[]{newX,newY};
    }

    public float getAngleKat(float a, float b){
        return (float)Math.toDegrees(Math.atan(tanAngle(a,b)));

    }

    public float getAngleDiagonal(float k, float g){
        return (float) Math.toDegrees(Math.acos(cosAngle(k,g)));
    }

    public float getPythagorasGip(float w, float h){
        return (float) Math.sqrt(w*w+h*h);
    }

    public float getPythagorasKat(float g,float h){
        return (float) Math.sqrt(g*g-h*h);
    }

    public float sideTriangle(PointF a, PointF b){
        float x = a.x -b.x;
        float y = a.y-b.y;
        return getPythagorasGip(x,y);
    }

    public PointF calculateVector(PointF a, PointF b){
        return new PointF(b.x-a.x,b.y-a.y);
    }

    public float scalarProduct(PointF a, PointF b){
        return  a.x*b.x+a.y*b.y;
    }

    public float cosAngle(float a, float b){
        return a/b;
    }

    public float tanAngle(float a, float b){
        return a/b;
    }




}
