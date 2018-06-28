package hci.onilearn.onilearn.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hci.onilearn.onilearn.fragment.AnalyzeFragment;
import hci.onilearn.onilearn.fragment.CategoryFragment;
import hci.onilearn.onilearn.fragment.TimeTableFragment;

//import com.onilearnapp.onilearnapp.Fragment.AnalyzeFragment;
//import com.onilearnapp.onilearnapp.Fragment.CategoryFragment;
//import com.onilearnapp.onilearnapp.Fragment.TimeTableFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private Fragment category, timetable, analyze;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (category == null)
                    return new CategoryFragment();
                else
                    return category;
            case 1:
                if (timetable == null)
                    return new TimeTableFragment();
                else
                    return timetable;
            case 2:
                if (analyze == null)
                    return new AnalyzeFragment();
                else
                    return analyze;
            default:
                return null;
        }
//        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Subject";
            case 1:
                return "Timetable";
            case 2:
                return "Analyze";
            default:
                return null;
        }
//        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
