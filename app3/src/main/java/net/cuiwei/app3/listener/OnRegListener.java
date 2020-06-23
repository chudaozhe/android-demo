package net.cuiwei.app3.listener;


import net.cuiwei.app3.bean.Reg;

public interface OnRegListener {
    void onSuccess(Reg reg);
    void onError();
}
