package com.example.a0328;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.tname);
        t2=(EditText)findViewById(R.id.thei);
        t3=(EditText)findViewById(R.id.twei);
        txt=(TextView)findViewById(R.id.result);
        getWindow().setBackgroundDrawableResource(R.drawable.wei);

    }

    public void calc(View v){
        String n=t1.getText().toString();
        double a,b,re;
        a=0;b=-1;re=-1;
        try{
             a=Double.parseDouble(t2.getText().toString());
             b=Double.parseDouble(t3.getText().toString());
             re=b/Math.pow(a*0.01,2);
        }catch (Exception e){
            alert("please retry");
        }


        String ss=getResources().getString(R.string.result);



        if(re==-1){
            alert("err");
        }else if(re>0&&re<18.5){
            getWindow().setBackgroundDrawableResource(R.drawable.thin);
            alert(getResources().getString(R.string.toa_thin));
        }else if(re>=18.5&&re<24){
            getWindow().setBackgroundDrawableResource(R.drawable.perfet);
            alert(getResources().getString(R.string.toa_perfet));
        }else {
            getWindow().setBackgroundDrawableResource(R.drawable.fat);
            alert(getResources().getString(R.string.toa_fat));
        }
        txt.setTextSize(20);
        txt.setBackgroundColor(Color.CYAN);
        txt.setText(String.format(ss,n,re));
    }
    public void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }


}
