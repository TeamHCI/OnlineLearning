package hci.onilearn.onilearn.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.Category;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Category> categoryList;
    private SubjectAdapter subjectAdapter;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView txtCategoryName = (TextView) convertView.findViewById(R.id.txtCategoryName);
        RecyclerView lvSubject = (RecyclerView) convertView.findViewById(R.id.lsSubject);

        Category category = categoryList.get(position);
        txtCategoryName.setText(category.getName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
        lvSubject.setLayoutManager(layoutManager);
        subjectAdapter = new SubjectAdapter(convertView.getContext(),category.getSubjects());
        lvSubject.setAdapter(subjectAdapter);

        return convertView;
    }
}
