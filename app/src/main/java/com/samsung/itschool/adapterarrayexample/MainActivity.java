package com.samsung.itschool.adapterarrayexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    LinearLayout linearLayout;
    Button createButton;
    int i = 0;
    int userId = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.bookList);
        linearLayout = findViewById(R.id.my_linear);
        createButton = findViewById(R.id.createButton);

        //Подготовка данных - 1 этап формирование списка объектов
        final LinkedList<Book> books = new LinkedList<>();
        books.add(new Book("Жюль Верн","Дети капитана Гранта", R.drawable.book, "Приключения"));
        books.add(new Book("Федор Достоевский","Преступление и наказание", R.drawable.prestuplenie, "Классика"));
        books.add(new Book("Николай Гоголь", "Шинель", R.drawable.shinel, "Классика"));
        books.add(new Book("Иван Ефремов","Туманность Андромеды", R.drawable.book, "Фантастика"));
        books.add(new Book("Айзек Азимов","Основание", R.drawable.osnovanie, "Фантастика"));
        books.add(new Book("Евгений Гаглоев","Зерцалия", R.drawable.zertsalia, "Фэнтези"));

        //Подготовка данных - 2 этап формирования списка пар с ключами

        LinkedList<HashMap<String, Object>> listBooks = new LinkedList<>();
        for (int j = 0; j < books.size(); j++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("cover", books.get(j).coverID);
            map.put("title", books.get(j).title);
            map.put("author", books.get(j).author);
            map.put("genre", books.get(j).genre);
            listBooks.add(map);
        }

        //Подготовка данных 3 этап - вспомогательные массивы
        String [] keys = {"cover", "title", "author", "genre"};
        int [] toID = {R.id.cover, R.id.title, R.id.author, R.id.genre};
        //Подготовка адаптера
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item, books);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listBooks, R.layout.list_item,
                    keys, toID);
        //установить адаптер
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), i + ") " + books.get(i), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button newButton = new Button(getApplicationContext());
                newButton.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                newButton.setText("Кнопка №" + i);
                newButton.setTextSize(32);
                newButton.setId(userId + i);
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        linearLayout.removeView(view);
                    }
                });
                linearLayout.addView(newButton);
                i++;
            }
        });
    }
}
