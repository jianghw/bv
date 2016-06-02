package com.caijy.jhwei.bv.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by jhwei on 2016/5/30.
 * 基础类扩展
 */
public abstract class FlowTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewID());
        ButterKnife.bind(this);

        if (null != getIntent()) handleIntent(getIntent());

        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment fragment = getFirstFragment();
            if (null != fragment) addFragment(fragment);
        }

    }

    protected abstract int getContentViewID();

    protected void handleIntent(Intent intent) {}

    protected abstract BaseFragment getFirstFragment();

    @Override
    protected abstract int getFragmentContentID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
