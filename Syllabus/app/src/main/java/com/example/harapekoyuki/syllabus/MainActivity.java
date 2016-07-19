package com.example.harapekoyuki.syllabus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CourseItem item = (CourseItem)parent.getItemAtPosition(position);
        Intent intent = new Intent(this, CourseDetail.class);
        intent.putExtra("date", item.date);
        intent.putExtra("title", item.title);
        intent.putExtra("teacher", item.teacher);
        intent.putExtra("detail", item.detail);
        startActivity(intent);
    }

    private class CourseItem {
        String date;
        String title;
        String teacher;
        String detail;
    }

    private List<CourseItem> itemList;
    private ItemAdapter adapter;

    private void setCourseData() {
        CourseItem item = new CourseItem();
        item.date = "2/12";
        item.title = "ユーティリティによる実践(1)";
        item.teacher = "高橋 憲一";
        item.detail = "この講義では一つのアプリとして仕上げることを目標とします。";
        itemList.add(item);

        item = new CourseItem();
        item.date = "2/17";
        item.title = "ユーティリティによる実践(2)";
        item.teacher = "高橋 憲一";
        item.detail = "一つのアプリを仕上げることを目指す2回目";
        itemList.add(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<CourseItem>();
        adapter = new ItemAdapter(getApplicationContext(), 0, itemList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        setCourseData();

        listView.setOnItemClickListener(this);

    }

    private class ItemAdapter extends ArrayAdapter<CourseItem> {
        private LayoutInflater inflater;

        public ItemAdapter(Context context, int resource, List<CourseItem> object) {
            super(context, resource, object);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.lecture_row, null, false);
            TextView dateView = (TextView) view.findViewById(R.id.date);
            TextView titleView = (TextView) view.findViewById(R.id.title);
            CourseItem item = getItem(position);
            dateView.setText(item.date);
            titleView.setText(item.title);
            return view;
        }
    }
}
