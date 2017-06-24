package ua.com.pbyinyk.onactivityresultrequestcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.PriorityQueue;

import ua.com.pbyinyk.util.RequestCode;

/**
 * Created by 1 on 05.04.2016.
 */
public class MainActivity extends Activity {


    private TextView tvName;
    private TextView tvLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tvName=(TextView)findViewById(R.id.tvName);
        tvLang=(TextView)findViewById(R.id.tvLang);
    }

    public void onShow(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.setName:
                intent=new Intent(this,PresentedActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_PRESENTED);

                break;
            case R.id.setLang:
                intent=new Intent(this,LanguichActivity.class);
                startActivityForResult(intent,RequestCode.REQUEST_CODE_LANGUAGE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK ){
                switch (requestCode){
                    case RequestCode.REQUEST_CODE_PRESENTED:
                        String name=data.getStringExtra("name");
                        tvName.setText("Приємно познайомитись"+ name);
                        break;
                    case RequestCode.REQUEST_CODE_LANGUAGE:
                    String namel=data.getStringExtra("language");
                    tvLang.setText(namel);
                    break;

                }
        }else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }

    }
}
