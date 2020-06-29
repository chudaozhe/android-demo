package net.cuiwei.recyclerviewgroup.model;

import android.util.Log;

import net.cuiwei.recyclerviewgroup.bean.Topics;
import net.cuiwei.recyclerviewgroup.listener.OnListListener;
import net.cuiwei.recyclerviewgroup.service.TopicService;
import net.cuiwei.recyclerviewgroup.utility.Http;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TopicModel {
    /**
     * 列表
     * @param mlistener
     */
    public void list(OnListListener<Topics> mlistener) {
        TopicService service = Http.getManager().getRetrofit().create(TopicService.class);
        service.list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArrayList<Topics>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<Topics> re) {
                        //JokeListResponse re=response.body();
                        if (re.size() > 0) {
                            Log.e("joke", "成功");
                            System.out.println(re.toString());
                            mlistener.onSuccess(re);

                        } else {
                            Log.e("joke", "失败");
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