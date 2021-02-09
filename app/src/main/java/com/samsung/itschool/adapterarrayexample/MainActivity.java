package com.samsung.itschool.adapterarrayexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.bookList);

        //Подготовка данных
        final LinkedList<String> books = new LinkedList<>();
        books.add("Дети капитана Гранта");
        books.add("Война и мир");
        books.add("Обломов");
        books.add("Туманность Андромеды");
        books.add("Солярис");
        books.add("Солярис");
        books.add("Солярис");
        books.add("Солярис");
        books.add("Солярис");
        books.add("Солярис");
        books.add("Лезвие бритвы");
        books.add("Пятая волна");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("Таинственный остров");
        books.add("80 тысяч лье под водой");

        //Подготовка адаптера
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item, books);

        //установить адаптер
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), i + ") " + books.get(i), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
