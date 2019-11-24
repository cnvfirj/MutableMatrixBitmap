package com.example.mutablematrixbitmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mutmatrix.CompRep;
import com.example.mutmatrix.DeformMat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import io.reactivex.Observable;

public class DrawView extends View {

    private Bitmap bitmap;

    private DeformMat mat;

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void stop(){
        if(test()){
            bitmap.recycle();
        }
        saveState();
    }



    public void command(DeformMat.Command command){
        mat.command(command);
    }

    private void init(){
        bitmap = BitmapFactory.decodeResource(getContext().getResources(),R.drawable.pic);
        mat = new DeformMat(getContext()).bitmap(new PointF(bitmap.getWidth(),bitmap.getHeight()));
        command(DeformMat.Command.TRANSLATE);
        requestData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(test()){
            canvas.drawBitmap(bitmap,mat.matrix(null),null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mat.event(event);
        invalidate();
        return true;
    }

    private boolean test(){
        if(bitmap!=null&&!bitmap.isRecycled()){
            return true;
        }else return false;
    }

    private void saveState(){
        if(mat.getRepository()!=null)requestSave(mat.getRepository());
    }

    @SuppressLint("CheckResult")
    private void requestSave(CompRep rep){
        Observable.just(saveSt(rep)).compose(new ThreadTransformers.InputOutput<>());
    }

    private boolean saveSt(CompRep rep){

        final File file = new File(getContext().getFilesDir().getPath()+"/state.rep");
        if (file.exists()) {
            file.delete();
        }
        try {
            OutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(rep);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.exists();

    }

    private void requestData(){


            File data = new File(getContext().getFilesDir().getPath()+"/state.rep");

            try {
                InputStream fis = new FileInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(fis);

                CompRep rep = (CompRep) ois.readObject();
                if(rep!=null)mat.setRepository(rep);

                ois.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

    }

}
