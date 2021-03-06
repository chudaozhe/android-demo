package net.cuiwei.app3.service;


import net.cuiwei.app3.bean.Manual;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ManualService {
    //php手册列表
    @GET("/manual?type=api")
    Observable<ArrayList<Manual>> list(@Query("cid") int cid);

}
