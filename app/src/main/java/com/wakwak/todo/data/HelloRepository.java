package com.wakwak.todo.data;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Ryo on 2016/10/14.
 */

public class HelloRepository {

    public Observable<String> getHello() {
        return Observable.just("hello").delay(5L, TimeUnit.SECONDS).subscribeOn(Schedulers.io());
    }
}
