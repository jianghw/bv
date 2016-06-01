package com.caijy.jhwei.bv.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.caijy.jhwei.bv.R;

/**
 * Created by jhwei on 2016/5/30.
 */
public abstract class SameTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewID());
        if (null != getIntent()) handleIntent(getIntent());

        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment fragment = getFirstFragment();
            if (null != fragment) addFragment(fragment);
        }

    }

    private int getContentViewID() {
        return R.layout.activity_flow_type;
    }

    protected abstract BaseFragment getFirstFragment();

    @Override
    protected int getFragmentContentID() {
        return R.id.aty_fgt_container;
    }

    private void handleIntent(Intent intent) {

    }
}
