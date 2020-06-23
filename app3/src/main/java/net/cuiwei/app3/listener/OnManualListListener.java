package net.cuiwei.app3.listener;

import net.cuiwei.app3.bean.Manual;

import java.util.ArrayList;

public interface OnManualListListener {
    void onSuccess(ArrayList<Manual> list);
    void onError();
}
