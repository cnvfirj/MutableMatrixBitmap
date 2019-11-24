package com.example.mutablematrixbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mutmatrix.DeformMat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawView view;

    private Button trans, scale, deform, rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.drawView);
        trans = findViewById(R.id.trans);
        trans.setOnClickListener(this);
        scale = findViewById(R.id.scale);
        scale.setOnClickListener(this);
        deform = findViewById(R.id.deform);
        deform.setOnClickListener(this);
        rotate = findViewById(R.id.rotate);
        rotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trans:
                view.command(DeformMat.Command.TRANSLATE);
                break;
             case R.id.scale:
                 view.command(DeformMat.Command.SCALE);
                break;
             case R.id.rotate:
                 view.command(DeformMat.Command.ROTATE);
                break;
             case R.id.deform:
                 view.command(DeformMat.Command.DEFORM);
                break;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.stop();
    }

}
