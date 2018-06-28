package hci.onilearn.onilearn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.CategoryAdapter;
import hci.onilearn.onilearn.model.Category;
import hci.onilearn.onilearn.model.Subject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private ListView listView;
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        listView = (ListView) view.findViewById(R.id.lvCategory);
        categoryList = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("User Interface Programing",""));
        subjects.add(new Subject("Accounting",""));
        subjects.add(new Subject("Java",""));
        categoryList.add(new Category("Recent",subjects));
        subjects = new ArrayList<>();
        subjects.add(new Subject("Android",""));
        subjects.add(new Subject("Java",""));
        subjects.add(new Subject("HTML",""));
        subjects.add(new Subject("C#",""));
        subjects.add(new Subject("Ruby",""));
        subjects.add(new Subject("Javascript",""));
        subjects.add(new Subject("Python",""));
        categoryList.add(new Category("Software Engineering",subjects));

        categoryAdapter = new CategoryAdapter(this.getContext(),R.layout.category_item,categoryList);
        listView.setAdapter(categoryAdapter);

        return view;
    }

}
