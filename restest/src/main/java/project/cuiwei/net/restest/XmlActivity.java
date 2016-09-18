package project.cuiwei.net.restest;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

    }

    public void getXml(View view) {
        XmlResourceParser xrp = getResources().getXml(R.xml.books);
        StringBuilder sb = new StringBuilder("");
        try {
            while (xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
                if (xrp.getEventType() == XmlResourceParser.START_TAG){
                    String tag_name = xrp.getName();
                    if (tag_name.equals("book")){
                        //根据属性名获取属性值
                        String book_price = xrp.getAttributeValue(null, "price");
                        sb.append("价格：");
                        sb.append(book_price);

                        //根据属性索引获取属性值
                        String date = xrp.getAttributeValue(1);
                        sb.append(" 出版日期：");
                        sb.append(date);

                        //获取文本节点的值
                        sb.append(" 书名：");
                        sb.append(xrp.nextText());
                    }
                    sb.append("\n");
                }
                xrp.next();
            }
            TextView tv = (TextView) findViewById(R.id.show);
            tv.setText(sb.toString());

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
