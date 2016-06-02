package com.caijy.jhwei.bv.data;

import com.caijy.jhwei.bv.data.local.LocalData;
import com.caijy.jhwei.bv.data.remote.RemoteData;

public class Injection {
    public static Repository provideTwoData() {
        return Repository.getInstance(RemoteData.getInstance(), LocalData.getInstance());
    }
}
