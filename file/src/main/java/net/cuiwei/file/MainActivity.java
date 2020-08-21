package net.cuiwei.file;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {
    public ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.my_bg);
        Log.e("bitmap", bitmap.toString());

        byte[] bytes=bitmap2byte(bitmap);
        Bitmap bitmap1=byte2bitmap(bytes);
        imageView.setImageBitmap(bitmap1);
    }

    /**
     * byte[] -> Bitmap
     * @param b
     * @return
     */
    public Bitmap byte2bitmap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);
        } else {
            return null;
        }
    }

    /**
     * Bitmap -> byte[]
     * @param bitmap
     * @return
     */
    public byte[] bitmap2byte(Bitmap bitmap) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     * 貌似不行
     * byte[] -> Bitmap
     * @param bytes
     * @return
     */
    public Bitmap byte2bitmap2(byte[] bytes){
        Bitmap bitmap=Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bytes));
        return bitmap;
    }
    /**
     * 貌似不行
     * Bitmap -> byte[]
     * @param bitmap
     * @return
     */
    public byte[] bitmap2byte2(Bitmap bitmap){
        int count=bitmap.getByteCount();
        ByteBuffer buffer=ByteBuffer.allocate(count);
        bitmap.copyPixelsToBuffer(buffer);
        return buffer.array();
    }
}
