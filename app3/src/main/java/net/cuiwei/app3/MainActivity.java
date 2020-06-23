package net.cuiwei.app3;

import android.content.Intent;
import android.os.Bundle;

import net.cuiwei.app3.activity.ListActivity;
import net.cuiwei.app3.activity.RecyclerActivity;
import net.cuiwei.app3.activity.TagsActivity;

import net.cuiwei.app3.activity.ListDiyActivity2;
import net.cuiwei.app3.activity.ListDiyActivity;
import net.cuiwei.app3.activity.RegResultActivity;
import net.cuiwei.app3.activity.TabTestActivity;
import net.cuiwei.app3.bean.Person;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn =(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText passwd = (EditText) findViewById(R.id.passwd);
                RadioButton sexd = (RadioButton) findViewById(R.id.sex);
                String sex = sexd.isChecked() ? "男" : "女";
                Person p = new Person(name.getText().toString(), passwd.getText().toString(), sex);

                Bundle data = new Bundle();
                data.putSerializable("person", p);

                Intent intent = new Intent(MainActivity.this, RegResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);

            }
        });


        //调起新闻列表
        Button listbtn = (Button) findViewById(R.id.list);
        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        //调起Tab
        Button tabbtn = (Button) findViewById(R.id.tab);
        tabbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd = new Intent();
                intentd.setClass(MainActivity.this, TabTestActivity.class);
                startActivity(intentd);
            }
        });

        //调起Tab2
        Button tabbtn2 = (Button) findViewById(R.id.diylist);
        tabbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentd = new Intent();
                intentd.setClass(MainActivity.this, ListDiyActivity.class);
                startActivity(intentd);
            }
        });
    }

    //文章
    public void Article(View v){
        Intent intent = new Intent(MainActivity.this, ListDiyActivity2.class);
        startActivity(intent);
    }
    //Tags
    public void Tags(View v){
        Intent intent = new Intent(MainActivity.this, TagsActivity.class);
        startActivity(intent);
    }
    //Recycler
    public void Recycler(View v){
        Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
        startActivity(intent);
    }
}
