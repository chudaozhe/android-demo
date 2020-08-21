package net.cuiwei.news;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
    /**
     * Common
     * @param v
     */
    public void Common(View v){
        Toast.makeText(FormActivity.this, "chick it", Toast.LENGTH_SHORT).show();
    }
}
