package project.cuiwei.net.materialtabs;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.karim.MaterialTabs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        setContentView(R.layout.activity_main);
        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);
        int numberOfTabs = 3;
//        if (getIntent() != null && getIntent().getExtras() != null) {
//            numberOfTabs = getIntent().getExtras().getInt(TabsSettingsFragment.NUMBER_OF_TABS);
//        }
        pager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager(), numberOfTabs));

// Bind the tabs to the ViewPager
        MaterialTabs tabs = (MaterialTabs) findViewById(R.id.material_tabs);
        tabs.setViewPager(pager);
        tabs.setIndicatorColor(R.color.colorAccent);
    }
}
