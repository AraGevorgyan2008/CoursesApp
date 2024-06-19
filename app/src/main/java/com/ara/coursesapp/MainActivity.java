package com.ara.coursesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ara.coursesapp.Adapter.CategoryAdapter;
import com.ara.coursesapp.Adapter.CourseAdapter;
import com.ara.coursesapp.model.Category;
import com.ara.coursesapp.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView,couresRecycle;
    private CategoryAdapter categoryAdapter;
    private static CourseAdapter courseAdapter;
    static List<Course> list1 = new ArrayList<>();
     static List<Course> list2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Category> list = new ArrayList<>();
        list.add(new Category(1,"Игры"));
        list.add(new Category(2,"Сайты"));
        list.add(new Category(3,"Языки"));
        list.add(new Category(4,"Прочее"));

        setCategoryAdpter(list);



        list1.add(new Course(1,"java","Профессия Java\n разработчик","начальный","1 января","#424345","Test",3));
        list1.add(new Course(2,"python","Профессия Python\n разработчик","начальный","10 января","#9FA52D","Test",3));
        list1.add(new Course(3,"backend","Профессия Backend\n разработчик","начальный","17 января","#2471ed","Test",2));
        list1.add(new Course(4,"unity","Профессия Unity\n разработчик","начальный","17 января","#21a645","Test",1));
        list1.add(new Course(5,"fullstack","Профессия FullStack\n разработчик","начальный","17 января","#0fc5fc","Test",4));
        list2.addAll(list1);
        setCourseAdpter(list1);
    }

    private void setCourseAdpter(List<Course> list1) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        couresRecycle = findViewById(R.id.couresRecycle);
        couresRecycle.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this,list1);
        couresRecycle.setAdapter(courseAdapter);
    }

    private void setCategoryAdpter(List<Category> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
            recyclerView = findViewById(R.id.recycleview);
            recyclerView.setLayoutManager(layoutManager);
            categoryAdapter = new CategoryAdapter(this,list);
            recyclerView.setAdapter(categoryAdapter);

    }
    public  static  void  showAllCategory(View view){
        list1.clear();
        list1.addAll(list2);
        courseAdapter.notifyDataSetChanged();
    }
    public static void showCategory(int category){

        list1.clear();
        list1.addAll(list2);
        List<Course> filtercategory = new ArrayList<>();
        for (Course a : list1){
            if (a.getCategory() == category){
                filtercategory.add(a);
            }
        }
        list1.clear();
        list1.addAll(filtercategory);

        courseAdapter.notifyDataSetChanged();
    }
    public void goOrderPage(View view){
        Intent s = new Intent(this, OrderPage.class);
        startActivity(s);
    }
}