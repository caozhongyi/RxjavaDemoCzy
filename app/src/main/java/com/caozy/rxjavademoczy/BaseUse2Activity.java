package com.caozy.rxjavademoczy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * rxjava 的基本使用
 */
public class BaseUse2Activity extends BaseActivity{

    private static final String TAG = "==========";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                System.out.println("+++++++++++++++++++++++++++++" + 1);
                emitter.onNext(2);
                System.out.println("+++++++++++++++++++++++++++++" + 2);
                emitter.onNext(3);
                System.out.println("+++++++++++++++++++++++++++++" + 3);
                /* 这里如果有异常的话，一定是发生在 onComplete 之前，不然异常无法被捕获处理造成闪退 */
//                String a = null;
//                a.length();
//                String[] b = {"1"};
//                b[5].length();
                //如果 onError 之前没有异常发生， 那么 onError 之后的代码将继续执行，但是不会被观察者捕获
//                emitter.onError(new Throwable("Throw an error !"));
                //当我们已经抛出了一个异常那么第二个异常也无法被捕获处理造成闪退
//                emitter.onError(new Throwable("Throw second error !"));
                System.out.println("+++++++++++++++++++++++++++++" + "onError");
                emitter.onComplete();
                System.out.println("+++++++++++++++++++++++++++++" + "onComplete");
                emitter.onNext(4);
                System.out.println("+++++++++++++++++++++++++++++" + 4);

            }
        }).subscribe(new Observer<Integer>() {

            Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG + "onSubscribe", d.isDisposed() + "");
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG + "onNext", integer + "");
                if (integer == 3) {
                    //切换操作，观察者不再接受上游事件， 此后上游Observable将不能再抛出异常，否则异常无法被捕获处理。
                    disposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG + "onError", e.getMessage().toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG + "onComplete", "onComplete");
            }
        });
    }
}
