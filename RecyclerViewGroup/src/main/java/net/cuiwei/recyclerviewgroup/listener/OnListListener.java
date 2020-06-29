package net.cuiwei.recyclerviewgroup.listener;


import java.util.ArrayList;

public interface OnListListener<T> {
    void onSuccess(ArrayList<T> list);
    void onError();
}
