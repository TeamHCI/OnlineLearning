package hci.onilearn.onilearn.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHoder> {

    private Context context;
    private int layout;
    private List<Category> categoryList;
    private SubjectAdapter subjectAdapter;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }
    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryAdapter.ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Category category = categoryList.get(position);
        holder.txtCategoryName.setText(category.getName());

        LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false);
        holder.lvSubject.setLayoutManager(layoutManager);
        subjectAdapter = new SubjectAdapter(context,category.getSubjects());
        holder.lvSubject.setAdapter(subjectAdapter);
    }

    @Override
    public int getItemCount() {
        if (categoryList != null)
            return categoryList.size();
        else
            return 0;
    }


    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView txtCategoryName;
        RecyclerView lvSubject;
        public ViewHoder(View itemView) {
            super(itemView);
            txtCategoryName = (TextView) itemView.findViewById(R.id.txtCategoryName);
            lvSubject = (RecyclerView) itemView.findViewById(R.id.lsSubject);
        }
    }
}
