package com.example.suncica.todo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suncica on 10/20/2016.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<Element> list = new ArrayList<Element>();

    public class ViewHolder {
        public TextView text;
        public CheckBox box;
        public LinearLayout ll;
    }

    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;
        Element element = new Element();

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_element, null);

            vh = new ViewHolder();
            vh.text = (TextView) convertView.findViewById(R.id.todotext);
            vh.box = (CheckBox) convertView.findViewById(R.id.taskdone);
            vh.ll = (LinearLayout) convertView.findViewById(R.id.element_layout);

            convertView.setTag(vh);

        } else {

            vh = (ViewHolder) convertView.getTag();
        }
        element = list.get(position);

        vh.text.setText(element.getToDoTask());

        if (element.getTaskDone() == true)
            vh.box.setChecked(true);
        else
            vh.box.setChecked(false);

        String color = element.getColor();

        String pasreColor = "#FFFFFF";

        switch (color) {
            case "yellow":
                pasreColor = "#E7E358";
                break;
            case "red":
                pasreColor = "#CF000F";
                break;
            case "green":
                pasreColor = "#03C9A9";
                break;
            case "blue":
                pasreColor = "#81CFE0";
                break;
            case "dark":
                pasreColor = "#8F58E7";
                break;
            case "pink":
                pasreColor = "#FF5733";
                break;
            case "none":
                break;
        }
        vh.ll.setBackgroundColor(Color.parseColor(pasreColor));

        return convertView;

    }

    public void update(Element[] elements) {
        list.clear();
        if (elements != null) {
            for (Element element : elements) {
                list.add(0, element);
            }
        }
        notifyDataSetChanged();
    }

}
