package org.tensorflow.lite.examples.posenet.fitsum;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.miguelrochefort.fitnesscamera.R;

import org.json.JSONException;
import org.json.JSONObject;

public class First_register extends Fragment  {
    private EditText et_id, et_pass, et_name, et_age,et_weight,et_height,et_passck;
    private Button btn_register,validateButton;
    private AlertDialog dialog;
    private boolean validate=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_register, container, false);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //아이디 값 찾아주기
        et_id=getView().findViewById(R.id.et_id);
        et_pass=getView().findViewById(R.id.et_pass);
        et_name=getView().findViewById(R.id.et_name);
        et_age=getView().findViewById(R.id.et_age);
        et_weight=getView().findViewById(R.id.et_weight);
        et_height=getView().findViewById(R.id.et_height);
        et_passck=getView().findViewById(R.id.et_passck);
        validateButton=getView().findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {//id중복체크


            public void onClick(View view) {
                String userID=et_id.getText().toString();
                if(validate)
                {
                    return;
                }
                if(userID.equals("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder( getActivity() );
                    dialog=builder.setMessage("아이디는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            AlertDialog.Builder builder=new AlertDialog.Builder( getActivity() );
                            if(success){
                                dialog=builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                et_id.setEnabled(false);
                                validate=true;
                                validateButton.setText("확인");
                            }
                            else{
                                dialog=builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인",null)
                                        .create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest=new ValidateRequest(userID,responseListener);
                RequestQueue queue= Volley.newRequestQueue(getActivity());
                queue.add(validateRequest);     // 유효성 검사

            }
        });


        btn_register=getView().findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //editText에 입력되어있는 값을 get(가져온다)해온다
                String userID=et_id.getText().toString();
                final String userPass=et_pass.getText().toString();
                String userName=et_name.getText().toString();
                int userAge=Integer.parseInt(et_age.getText().toString());
                int userWeight=Integer.parseInt(et_weight.getText().toString());
                int userHeight=Integer.parseInt(et_height.getText().toString());
                final String PassCk=et_passck.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>() {//volley
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject=new JSONObject(response);//Register2 php에 response
                            boolean success=jasonObject.getBoolean("success");//Register2 php에 sucess
                            if(userPass.equals(PassCk)) {
                                if (success) {//회원등록 성공한 경우
                                    Toast.makeText(getActivity(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity(), FirstActivity.class);
                                    startActivity(intent);
                                }
                            }
                            else{//회원등록 실패한 경우
                                Toast.makeText(getActivity(),"회원 등록 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 volley를 이용해서 요청을 함
                RegisterRequest registerRequest=new RegisterRequest(userID,userPass, userName, userAge,userWeight,userHeight,responseListener);
                RequestQueue queue= Volley.newRequestQueue(getActivity());
                queue.add(registerRequest);
            }
        });
    }

}
