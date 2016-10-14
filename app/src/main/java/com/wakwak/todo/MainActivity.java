package com.wakwak.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wakwak.todo.data.HelloRepository;
import com.wakwak.todo.domain.HelloUseCase;
import com.wakwak.todo.presentation.presenter.HelloPresenter;
import com.wakwak.todo.presentation.presenter.HelloPresenterImpl;
import com.wakwak.todo.presentation.view.HelloView;

public class MainActivity extends AppCompatActivity implements HelloView {

    private HelloPresenter presenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        presenter = new HelloPresenterImpl(new HelloUseCase(new HelloRepository()));
        presenter.attachView(this);
        presenter.showHello();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showHello(String text) {
        textView.setText(text);
    }
}
