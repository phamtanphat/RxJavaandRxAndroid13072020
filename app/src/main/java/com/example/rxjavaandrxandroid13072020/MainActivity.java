package com.example.rxjavaandrxandroid13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity{

    Sinhvien sinhvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Observable<String> stringObservable = Observable.fromArray("Teo","Ti","Tun","Hoa","Lan");
//        stringObservable
//                .subscribeOn(Schedulers.io())
//                .filter(new Predicate<String>() {
//                    @Override
//                    public boolean test(String s) throws Throwable {
//                        if (s.length() == 2){
//                            return false;
//                        }
//                        return true;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        sinhvien = new Sinhvien("Nguyen Van Teo",20);
        Observable<Sinhvien> sinhvienObservable = Observable.defer(new Supplier<ObservableSource<? extends Sinhvien>>() {
            @Override
            public ObservableSource<? extends Sinhvien> get() throws Throwable {
                return Observable.just(sinhvien);
            }
        });
        sinhvien = new Sinhvien("Nguyen Van Ty",25);
        sinhvienObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Sinhvien>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Sinhvien sinhvien) {
                        Log.d("BBB",sinhvien.name +  sinhvien.age);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }


}
