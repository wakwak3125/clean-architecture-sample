package com.wakwak.todo.presentation.presenter;

import com.wakwak.todo.domain.HelloUseCase;
import com.wakwak.todo.presentation.view.HelloView;

import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Ryo on 2016/10/14.
 */

public class HelloPresenterImpl implements HelloPresenter {

    private HelloView view;
    private HelloUseCase useCase;
    private CompositeSubscription subscription;

    public HelloPresenterImpl(HelloUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void attachView(HelloView view) {
        this.view = view;
        subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        subscription.clear();
    }

    @Override
    public void showHello() {
        subscription.add(
                useCase.getHello().subscribe(new Action1<String>() {
                    @Override
                    public void call(String hello) {
                        view.showHello(hello);
                    }
                })
        );
    }
}
