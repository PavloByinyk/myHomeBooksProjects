package ua.com.pbyinyk.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void showDialog(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Це тайтл")
                .setMessage("Привіт світ")
                .setCancelable(true).setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("Відхилити", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Тостовий текст no",Toast.LENGTH_LONG).show();

                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Тостовий текст yes",Toast.LENGTH_LONG).show();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(getApplicationContext(),"back",Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alert =builder.create();
        alert.show();
    }

}
