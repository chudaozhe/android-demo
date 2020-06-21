package com.example.work.myapplication.model;

import android.util.Log;

import com.example.work.myapplication.bean.Reg;
import com.example.work.myapplication.listener.OnRegListener;
import com.example.work.myapplication.service.RegService;
import com.example.work.myapplication.utility.Http;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegModel {
    /**
     * 详情
     */
    public void reg(String name, final OnRegListener mlistener) {
        RegService service = Http.getManager().getRetrofit().create(RegService.class);
        service.reg(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Reg>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Reg re) {
//                        Reg reg=re;
                        if (re.status==1){
                            Log.e("result", "成功");
                            mlistener.onSuccess(re);
                        }else {
                            Log.e("result", "失败");
                            mlistener.onError();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        mlistener.onError();
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
