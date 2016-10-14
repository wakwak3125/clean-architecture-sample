package com.wakwak.todo.domain;

import com.wakwak.todo.data.HelloRepository;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by Ryo on 2016/10/14.
 */

public class HelloUseCase {

    private HelloRepository repository;

    public HelloUseCase(HelloRepository repository) {
        this.repository = repository;
    }

    public Observable<String> getHello() {
        return repository.getHello().map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s.toUpperCase();
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }
}
