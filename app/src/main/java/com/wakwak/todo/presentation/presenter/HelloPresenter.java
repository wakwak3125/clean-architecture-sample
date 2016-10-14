package com.wakwak.todo.presentation.presenter;

import com.wakwak.todo.presentation.view.HelloView;

/**
 * Created by Ryo on 2016/10/14.
 */

public interface HelloPresenter {

    void attachView(HelloView view);

    void detachView();

    void showHello();
}
