package gottgried.example.com.mycrashbeta2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
    }
}
