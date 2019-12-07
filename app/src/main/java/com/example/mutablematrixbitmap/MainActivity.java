package com.example.mutablematrixbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mutmatrix.DeformMat;

import static com.example.mutmatrix.DeformMat.SpecialCommand.RESET_DEFORM;
import static com.example.mutmatrix.DeformMat.SpecialCommand.RESET_ROTATE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawView view;

    private Button trans, scale, deform, rotate, resetD, resetR, scalS, resetDR;

    private TextView text;

    private int indexScalar = 0;

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
        resetD = findViewById(R.id.reset_def);
        resetD.setOnClickListener(this);
        resetR = findViewById(R.id.reset_rot);
        resetR.setOnClickListener(this);
        scalS = findViewById(R.id.scalar);
        scalS.setOnClickListener(this);
        resetDR = findViewById(R.id.reset_def_rot);
        resetDR.setOnClickListener(this);
        text = findViewById(R.id.text);
        text.setText("translate");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trans:
                view.command(DeformMat.Command.TRANSLATE);
                text.setText("translate");
                break;
             case R.id.scale:
                 view.command(DeformMat.Command.SCALE);
                 text.setText("two-touch zoom");
                break;
             case R.id.rotate:
                 view.command(DeformMat.Command.ROTATE);
                 text.setText("rotate");
                break;
             case R.id.deform:
                 view.command(DeformMat.Command.DEFORM);
                 text.setText("deformation");
                break;

            case R.id.reset_def:
                view.special(new DeformMat.SpecialCommand[]{RESET_DEFORM});
                text.setText("reset deformation");
                break;
             case R.id.reset_rot:
                 view.special(new DeformMat.SpecialCommand[]{RESET_ROTATE});
                 text.setText("reset rotate");
                break;
             case R.id.reset_def_rot:
                 view.special(new DeformMat.SpecialCommand[]{RESET_DEFORM, RESET_ROTATE});
                 text.setText("reset rotate and deformation");
                break;
             case R.id.scalar:
                 view.special(new DeformMat.SpecialCommand[]{DeformMat.SpecialCommand.values()[indexScalar]});
                 if(indexScalar==0)text.setText("max scalar");
                 else if(indexScalar==1)text.setText("min scalar");
                 else if(indexScalar==2)text.setText("adapt scalar");
                 else if(indexScalar==3)text.setText("non scalar");
                 indexScalar++;
                 if(indexScalar>3)indexScalar=0;
                break;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.start();
    }
}
