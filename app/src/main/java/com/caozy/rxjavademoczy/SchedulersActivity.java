package com.caozy.rxjavademoczy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * rxjava 的线程调度示例
 */
public class SchedulersActivity extends BaseActivity{

    Observable<String> observable;
    Observer1 observer1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("one");
                Thread.sleep(1000);
                emitter.onNext("two");
                Thread.sleep(1000);
                emitter.onNext("three");
            }
        });

        observer1 = new Observer1();
        observable
                //指定发射事件的线程为 io 线程
                .subscribeOn(Schedulers.io())
                //指定接收
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer1);

    }


    class Observer1 implements Observer<String> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            Log.e("==============", s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
