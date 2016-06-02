package com.caijy.jhwei.bv.data;

import com.caijy.jhwei.bv.data.local.LocalData;
import com.caijy.jhwei.bv.data.remote.RemoteData;

/**
 * Created by Administrator on 2016/6/2 0002</br>
 * description:</br>
 */
public class Repository {

    private volatile static Repository instance;
    private RemoteData mRemoteData;
    private LocalData mLocalData;

    public Repository(RemoteData remoteData, LocalData localData) {
        mRemoteData = remoteData;
        mLocalData = localData;
    }

    public static Repository getInstance(RemoteData remoteData, LocalData localData) {
        if (instance == null) {
            synchronized (Repository.class) {
                if (instance == null) instance = new Repository(remoteData, localData);
            }
        }
        return instance;
    }
}
