package net.cuiwei.layout;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import net.cuiwei.layout.R;

public class VolleyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        ImageView img1 = (ImageView) findViewById(R.id.img1);

        RequestQueue mQueue = Volley.newRequestQueue(this);

        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
            }

            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }
        });

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(img1,
                R.drawable.ic_launcher, R.drawable.ic_launcher);

        imageLoader.get("https://test.cuiwei.net/phpMyAdmin/themes/pmahomme/img/logo_right.png", listener);



//        img1.setImageResource(R.drawable.ok);
//        img1.setBackgroundResource(R.drawable.ok);
//        img1.setImageDrawable( getResources().getDrawable(drawable.ok));
    }

}
