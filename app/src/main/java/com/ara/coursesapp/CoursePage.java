package com.ara.coursesapp;

import static com.ara.coursesapp.OrderPage.OrderAllTitle;
import static com.ara.coursesapp.OrderPage.adapter;
import static com.ara.coursesapp.OrderPage.listAllTitle;
import static com.ara.coursesapp.OrderPage.listTitle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ara.coursesapp.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.coursesPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout courseBg = findViewById(R.id.coursesPage);
        ImageView courseIMG = findViewById(R.id.coursePageIMG);
        TextView courseTitle = findViewById(R.id.page_title);
        TextView courseDate = findViewById(R.id.courseDataPage);
        TextView courseLevel = findViewById(R.id.courselevelPage);
        TextView courseText = findViewById(R.id.page_description);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseIMG.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));


    }

    public void addCart(View view){
        int id = getIntent().getIntExtra("courseID",0);
        Order.Item_id.add(id);
        Toast.makeText(this, "Order :)", Toast.LENGTH_SHORT).show();
    }

}