package com.example.work.myapplication.listener;


import com.example.work.myapplication.bean.Reg;

public interface OnRegListener {
    void onSuccess(Reg reg);
    void onError();
}
