package com.train;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<Student> studentList;
    ListView listView;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        Student obj1=new Student("Abhishek Soy","MCA",79);
        Student obj2=new Student("Shobhit Rai","MCA",99);
        Student obj3=new Student("Rahul Kumar","MCA",100);
        Student obj4=new Student("Vivek Mishra","MCA",88);
        Student obj5=new Student("Pankaj Kumar","MCA",83);

        studentList=new ArrayList<Student>();
        studentList.add(obj1);
        studentList.add(obj2);
        studentList.add(obj3);
        studentList.add(obj4);
        studentList.add(obj5);

        Custom_ListAdapter adapter =  new Custom_ListAdapter(this,R.layout.custom_listview_row, studentList);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}