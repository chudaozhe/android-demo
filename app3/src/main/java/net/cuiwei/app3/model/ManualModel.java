package net.cuiwei.app3.model;

import android.util.Log;

import net.cuiwei.app3.bean.Manual;
import net.cuiwei.app3.listener.OnManualListListener;
import net.cuiwei.app3.service.ManualService;
import net.cuiwei.app3.utility.Http;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ManualModel {
    /**
     * 列表
     * @param cid
     * @param mlistener
     */
    public void list(int cid, final OnManualListListener mlistener) {
            ManualService service = Http.getManager().getRetrofit().create(ManualService.class);
        service.list(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArrayList<Manual>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ArrayList<Manual> re) {
                        //BaseListResponse re=response.body();
//                        BaseListResponse2 re2 =re.data;
//                        ArrayList<Manual> arrayList=re;
                        if (re.size()>0){
                            Log.e("result", "成功");
                            System.out.println(re.toString());
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
