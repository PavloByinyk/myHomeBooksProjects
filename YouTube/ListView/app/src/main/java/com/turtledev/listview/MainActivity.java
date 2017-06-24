package com.turtledev.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);
    }
}
