package sg.edu.rp.c346.id21025290.democustomcontactlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+"+currentItem.getCountryCode());
        tvNum.setText(String.valueOf(currentItem.getPhoneNum()));

        String draw = "male";
        int id = parent_context.getResources().getIdentifier(draw, "drawable", parent_context.getPackageName());
        Drawable img = parent_context.getResources().getDrawable(id);

        if (currentItem.getGender() == 'M'){
            ivGender.setImageDrawable(img);
        } else if (currentItem.getGender() == 'F'){
            ivGender.setImageResource(R.drawable.female);
        }


        return rowView;

    }
}
