package hci.onilearn.onilearn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.CategoryAdapter;
import hci.onilearn.onilearn.model.Category;
import hci.onilearn.onilearn.model.MyData;

/**
 * A simple {@link Fragment} subclass.
 */

public class CategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.lvCategory);
        categoryList = MyData.categories;


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(getContext(), categoryList);
        recyclerView.setAdapter(categoryAdapter);

        return view;
    }
}
