package net.cuiwei.app3.service;
import net.cuiwei.app3.bean.Reg;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegService {
    //模拟注册返回值
    @FormUrlEncoded   //别丢了
    @POST("/reg.php")
    Observable<Reg> reg(@Field("name") String name);

}
