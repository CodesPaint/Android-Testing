package com.train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Custom_ListAdapter extends ArrayAdapter<Student> {
    private LayoutInflater mInflater;
    private ArrayList<Student> students;
    private int mViewResourceId;

   public Custom_ListAdapter(Context context, int textViewResourceId, ArrayList<Student> students){
       super(context,textViewResourceId,students);
       this.students= students;
       mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       mViewResourceId = textViewResourceId;
   }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Student student = students.get(position);

        if (student != null) {
            TextView txtname = (TextView) convertView.findViewById(R.id.tvname);
            TextView txtdepartment = (TextView) convertView.findViewById(R.id.tvdepartment);
            TextView txtpercent = (TextView) convertView.findViewById(R.id.tvpercent);
            if (txtname != null) {
                txtname.setText(student.getName());
            }
            if (txtdepartment != null) {
                txtdepartment.setText(student.getDepartment());
            }
            if (txtpercent != null) {
                txtpercent.setText(student.getPercent()+"");
            }
        }

        return convertView;
    }
}
