package project.cuiwei.net.image;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class BitmapActivity extends AppCompatActivity {
    String[] images =null;
    AssetManager assets =null;
    int currentImg =0;
    ImageView image =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        image = (ImageView) findViewById(R.id.image);
        assets = getAssets();

        //核心
//        InputStream assetFile = null;
//        try {
//            assetFile = assets.open("ajax.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
        try {
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final Button next = (Button) findViewById(R.id.btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImg >= images.length) {
                    currentImg = 0;
                }
                while (!images[currentImg].endsWith(".png")
                        && !images[currentImg].endsWith(".jpg")
                        && !images[currentImg].endsWith(".gif")) {
                    currentImg++;
                    if (currentImg >= images.length) {
                        currentImg = 0;
                    }
                }
                    InputStream assetFile = null;
                    try {
                        assetFile = assets.open(images[currentImg++]);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                    if (bitmapDrawable != null
                            && !bitmapDrawable.getBitmap().isRecycled()) // ①
                    {
                        bitmapDrawable.getBitmap().recycle();
                    }
                    image.setImageBitmap(BitmapFactory.decodeStream(assetFile));
                }


        });
    }

    public void Test(View view) {
        currentImg++;
        if (currentImg==5)
//        Toast.makeText(BitmapActivity.this, "tip:"+currentImg, Toast.LENGTH_LONG).show();
        Toast.makeText(BitmapActivity.this, "tip:点多了会怀孕", Toast.LENGTH_SHORT).show();

        if (currentImg>=6)
            Toast.makeText(BitmapActivity.this, "tip:还点", Toast.LENGTH_SHORT).show();
    }
}
