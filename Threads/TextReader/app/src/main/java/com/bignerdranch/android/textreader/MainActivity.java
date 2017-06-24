package com.bignerdranch.android.textreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PipeExampleActivity";

    private EditText editText;
    PipedReader r;
    PipedWriter w;

    private Thread workerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        r = new PipedReader();
        w = new PipedWriter();

        try {
            w.connect(r);
        } catch (IOException e) {
            e.printStackTrace();
        }


        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
// обработка только добавленных символов
                    if (count > before) {
// заnись последнего введённого символа в канал
                        w.write(s.subSequence(start, ++start).toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        workerThread = new Thread(new TextHandlerTask(r));
        workerThread.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        workerThread.interrupt();
        try {
            r.close();
            w.close();
        } catch (IOException е) {

        }
    }


    private static class TextHandlerTask implements Runnable {
        private final PipedReader reader;
        //String text="";

        public TextHandlerTask(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    int i;

                    while ((i = reader.read()) != -1) {
                        String text="";
                        char с = (char) i;
                        text+=String.valueOf((char) i);
// ДОБАВЬТЕ СЮДА ОБРАБОТКУ ТЕКСТА
                        Log.d(TAG, "char = " + text);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}