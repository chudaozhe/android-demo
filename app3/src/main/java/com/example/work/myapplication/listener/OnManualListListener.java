package com.example.work.myapplication.listener;

import com.example.work.myapplication.bean.Manual;

import java.util.ArrayList;

public interface OnManualListListener {
    void onSuccess(ArrayList<Manual> list);
    void onError();
}
