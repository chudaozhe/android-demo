package project.cuiwei.net.restest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class PropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(new MyAnimationView(this));
    }
}
