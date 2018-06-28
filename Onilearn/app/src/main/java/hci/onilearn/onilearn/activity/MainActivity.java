package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE_TASK = 001;
    private MainPagerAdapter mainPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewPage);
        viewPager.setAdapter(mainPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mon_hoc,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuTime) {
//            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DatLichActivity.class);
            startActivityForResult(intent,REQUEST_CODE_TASK);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        for (Fragment fragment : getChildFragmentManager().getFragments()) {
//            fragment.onActivityResult(requestCode, resultCode, data);
//        }
        Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPage + ":" + 1);
        page.onActivityResult(requestCode, resultCode, data);
//        ((MainPagerAdapter)viewPager.getAdapter()).getItem(1).onActivityResult(requestCode, resultCode, data);
    Log.d("lala","1");
        super.onActivityResult(requestCode, resultCode, data);
    }

}
