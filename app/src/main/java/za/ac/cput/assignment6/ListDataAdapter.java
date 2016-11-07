package za.ac.cput.assignment6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.assignment6.model.LoginDetails;

/**
 * Created by rcarstens on 2016/11/07.
 */
public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView EMAIL,PASSWORD;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.EMAIL = (TextView)row.findViewById(R.id.textName);
            layoutHandler.PASSWORD = (TextView)row.findViewById(R.id.textSurname);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }

        LoginDetails dataAdapter = (LoginDetails) this.getItem(position);
        layoutHandler.EMAIL.setText(dataAdapter.getEmail());
        layoutHandler.PASSWORD.setText(dataAdapter.getPassword());

        return row;
    }
}
