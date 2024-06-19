package com.ara.coursesapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ara.coursesapp.model.Course;
import com.ara.coursesapp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    static List<String> listAllTitle = new ArrayList<>();
    static List<String> OrderAllTitle = new ArrayList<>();
    private  ListView orderview;
    static ArrayAdapter<String> adapter;
   Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       orderview = findViewById(R.id.OrderView);
        List<String> listTitle = new ArrayList<>();
        for (Course a : MainActivity.list2){
            if (Order.Item_id.contains(a.getId())){
                listTitle.add(a.getTitle());
            }
        }

        orderview.setAdapter( new ArrayAdapter<>(this, R.layout.order_item, R.id.ORderTV,listTitle));


    }
/*    public void removeTitle(View view){
        int id = getIntent().getIntExtra("courseID",0);


    }*/
}