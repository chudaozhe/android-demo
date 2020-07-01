package net.cuiwei.recyclerviewgroup.service;

import net.cuiwei.recyclerviewgroup.bean.Topics;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface TopicService {
    //段子列表
    @GET("/manual?type=topic")
    Observable<ArrayList<Topics>> list();


}
