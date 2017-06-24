package ua.com.pbyinyk.onactivityresultrequestcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ua.com.pbyinyk.util.Language;

/**
 * Created by 1 on 05.04.2016.
 */
public class LanguichActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.languach_layout);
    }

    public void onSelectedLanguage(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.btnEng:
                intent=new Intent();
                intent.putExtra("language", Language.ENGLISH.getLanguage());
                setResult(RESULT_OK,intent);
                finish();
            case R.id.btnUcr:
                intent=new Intent();
                intent.putExtra("language", Language.UCRAINE.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
            case R.id.btnRus:
                intent=new Intent();
                intent.putExtra("language", Language.RUSSIAN.getLanguage());
                setResult(RESULT_OK,intent);
                finish();
        }
    }
}
