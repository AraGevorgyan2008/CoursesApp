package com.ara.coursesapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ara.coursesapp.CoursePage;
import com.ara.coursesapp.R;
import com.ara.coursesapp.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private Context context ;
    private List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_item , parent,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));
int img = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(),"drawable",context.getPackageName());
        holder.courseimg.setImageResource(img);
        holder.courseData.setText(courses.get(position).getDate());
        holder.courselevel.setText(courses.get(position).getLevel());
        holder.courseTitle.setText(courses.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoursePage.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                        new Pair<View,String>(holder.courseimg,"courseImage"));
                intent.putExtra("courseBg",Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("courseImage",img);
                intent.putExtra("courseTitle",courses.get(position).getTitle());
                intent.putExtra("courseDate",courses.get(position).getDate());
                intent.putExtra("courseLevel",courses.get(position).getLevel());
                intent.putExtra("courseText",courses.get(position).getText());
                intent.putExtra("courseID",courses.get(position).getId());

                context.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {
 private CardView courseBg;
         private ImageView courseimg;
 private TextView courseTitle,courseData,courselevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseimg = itemView.findViewById(R.id.courseimg);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseData = itemView.findViewById(R.id.courseData);
            courselevel = itemView.findViewById(R.id.courselevel);
        }
    }
}
