package hci.onilearn.onilearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.CategoryAdapter;
import hci.onilearn.onilearn.model.Category;
import hci.onilearn.onilearn.model.MyData;

public class SubjectChoiceActivity extends AppCompatActivity {
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_choice);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(R.id.lvCategory);
        categoryList = MyData.categories;

        categoryAdapter = new CategoryAdapter(this, R.layout.category_item, categoryList);
        listView.setAdapter(categoryAdapter);
    }
}

