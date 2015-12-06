package com.example.callrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.callrecorder.data.base.Repository;
import com.example.callrecorder.data.base.TABLE;
import com.example.callrecorder.domain.entities.Calls;
import com.example.callrecorder.ui.CallsView;
import com.example.callrecorder.ui.Presenter;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CallsView {
    Presenter presenter;
    TextView textView;
    TABLE table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.fragment_calls_text);
        textView.setText("");
        presenter = new Presenter(this,new Repository(this));
        presenter.showCalls();

    }

    @Override
    public void showCalls(List<Calls> list) {
        for (int i = 0; i < list.size(); i++) {
            Calls calls = list.get(i);
            textView.append(calls.toString());
        }
    }
}
