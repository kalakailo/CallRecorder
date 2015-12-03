package com.example.callrecorder;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.callrecorder.data.base.DatabaseFactory;

public class MainActivity extends AppCompatActivity {

    DatabaseFactory databaseFactory;
    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.fragment_calls_text);
        textView.setText("");

        databaseFactory = new DatabaseFactory(this,"ZnSoftech.db", null, 2);

                Cursor cursor =databaseFactory.getData();

        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            do
            {
                String number=cursor.getString(0);
                String date=cursor.getString(1);
                String time=cursor.getString(2);
                String type=cursor.getString(3);

                textView.append("Number:"+number+"\nDate:"+date+"\nTime:"+time+
                        "\nCall Type:"+type+"\n\n");
            }while(cursor.moveToNext());
        }
        else
        {
            textView.setText("No Incoming and Outgoing call!!!");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            databaseFactory.deleteTable();
            textView.setText("No Incoming and Outgoing call!!!");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
