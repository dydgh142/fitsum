package org.tensorflow.lite.examples.posenet.fitsum;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://ayusoft.dothome.co.kr/UserValidate.php";   // 호스팅 주소
    private Map<String,String> map;

    public ValidateRequest(String userID, Response.Listener<String>listener){
        super(Request.Method.POST,URL,listener,null);   //post방식을 이용하여 데이터 통신

        map=new HashMap<>();
        map.put("userID",userID);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

// 아이디 중복 검사.java