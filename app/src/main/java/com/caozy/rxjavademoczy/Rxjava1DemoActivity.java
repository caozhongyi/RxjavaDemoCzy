//package com.caozy.rxjavademoczy;
//
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import rx.Observable;
//import rx.Observer;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Action1;
//import rx.functions.Func1;
//import rx.observables.SyncOnSubscribe;
//import rx.schedulers.Schedulers;
//
//public class Rxjava1DemoActivity extends AppCompatActivity{
//
//    ImageView imageView;
//    TextView textViewCount;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rxjava1demo);
//        imageView = findViewById(R.id.imageView);
//        textViewCount = findViewById(R.id.tv_count);
//
//        observable.subscribe(subscriber);
//        Observable.just("cao", "zhongyi").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                System.out.println("++++++++++++++++++++++++++++++" + s);
//            }
//        });
//
//        String[] strings = {"dhh", "2", "relj"};
////        observable.just(strings);
//        Observable.from(strings).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("-----------------------", s);
//            }
//        });
//
//        //设置图片
//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                //获取图片
//                Drawable drawable;
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                   drawable = getTheme().getDrawable(R.drawable.sign_please);
//                }else {
//                    drawable = getResources().getDrawable(R.drawable.sign_please);
//                }
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//            }
//        }).subscribe(new Action1<Drawable>() {
//            @Override
//            public void call(Drawable drawable) {
//                imageView.setImageDrawable(drawable);
//            }
//        });
//
//        //后台处理数据，前台设置
//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(1000);
//                        subscriber.onNext(i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                textViewCount.setText(integer + "");
//            }
//        });
//
//        //map
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//            }
//        }).map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return "";
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        });
//
//
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (!subscriber.isUnsubscribed()) {
//            subscriber.unsubscribe();
//        }
//    }
//
//    Observer<String> observer = new Observer<String>() {
//        @Override
//        public void onCompleted() {
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//
//        }
//
//        @Override
//        public void onNext(String s) {
//
//        }
//    };
//
//    Subscriber<String> subscriber = new Subscriber<String>() {
//
//        @Override
//        public void onStart() {
//            super.onStart();
//        }
//
//        @Override
//        public void onCompleted() {
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//
//        }
//
//        @Override
//        public void onNext(String s) {
//            System.out.println("============================" + s);
//        }
//    };
//
//    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//
//        @Override
//        public void call(Subscriber<? super String> subscriber) {
//            subscriber.onNext("hello");
//            subscriber.onNext("world");
//            subscriber.onCompleted();
//        }
//    });
//
//    Observable observable1 = Observable.create(new SyncOnSubscribe() {
//        @Override
//        protected Object generateState() {
//            return null;
//        }
//
//        @Override
//        protected Object next(Object state, Observer observer) {
//            return null;
//        }
//
//        @Override
//        public void call(Object o) {
//
//        }
//    });
//
//}
