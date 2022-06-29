package org.tensorflow.lite.examples.posenet.fitsum;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.miguelrochefort.fitnesscamera.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

//import org.tensorflow.lite.examples.posenet.SliderAdapter;

public class FirstActivity extends AppCompatActivity{

    /*
    SliderView sliderView;


    int[] images={R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four
    };
    */


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        //슬라이더 이미지
        /*
        sliderView=findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter=new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

         */


        //버튼 선언 하는 부분
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_register = findViewById(R.id.btn_register);

        //btn_login 누르면 프래그먼트가 뜨게함.
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        FirstActivity.this,R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = getLayoutInflater().from(getApplicationContext())
                        .inflate(
                                R.layout.first_login,
                                (LinearLayout)findViewById(R.id.bottom)
                        );


                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });


        //btn_register 누르면 프래그먼트가 뜨게함.
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        FirstActivity.this,R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = getLayoutInflater().from(getApplicationContext())
                        .inflate(
                                R.layout.first_register,
                                (LinearLayout)findViewById(R.id.bottom)
                        );


                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
    }
}
