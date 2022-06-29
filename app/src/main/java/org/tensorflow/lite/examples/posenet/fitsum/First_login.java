package org.tensorflow.lite.examples.posenet.fitsum;

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

public class First_login extends Fragment {
    private Button btn_login;
    private EditText et_id, et_pass;
    private View view;

    @Nullable
    public void onCreate(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //프래그먼트는 뷰를 활용해야함.
        view = inflater.inflate(R.layout.main_activity, container, false);
        //그냥 findView는 안됌.
        btn_login = view.findViewById(R.id.btn_login);
        et_pass = view.findViewById(R.id.et_pass);
        et_id = view.findViewById(R.id.et_id);

        //로그인시 메인 액티비티로 이동


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                final String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject = new JSONObject(response);
                            boolean success = jasonObject.getBoolean("success");
                            if (success) {//회원등록 성공한 경우
                                String userID = jasonObject.getString("userID");
                                String userPass = jasonObject.getString("userPassword");
                                Toast.makeText(getActivity(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                intent.putExtra("log", "User");
                                intent.putExtra("userID", userID);
                                startActivity(intent);
                            } else {//회원등록 실패한 경우
                                Toast.makeText(getActivity(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(loginRequest);
            }
        });
    }
}
    //fragment에서 입력한 데이터를 activity로 보내기 위한 메소드
    // fragment의 값을 activity에서 가져오기 위해서 호출하는 메소드;