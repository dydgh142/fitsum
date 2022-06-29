package org.tensorflow.lite.examples.posenet.fitsum;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import com.miguelrochefort.fitnesscamera.R;

public class MainActivity extends AppCompatActivity{

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //버튼 선언
        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);


        //버튼 클릭시 화면을 전환시키는 부분 1~4
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                Main_Frag1 mainFrag1 =new Main_Frag1();
                transaction.replace(R.id.frame, mainFrag1);
                transaction.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                Main_Frag2 mainFrag2 =new Main_Frag2();
                transaction.replace(R.id.frame, mainFrag2);
                transaction.commit();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                Main_Frag3 mainFrag3 =new Main_Frag3();
                transaction.replace(R.id.frame, mainFrag3);
                transaction.commit();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                Main_Frag4 mainFrag4 =new Main_Frag4();
                transaction.replace(R.id.frame, mainFrag4);
                transaction.commit();
            }
        });



    }
}
