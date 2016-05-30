package com.caijy.jhwei.bv.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jhwei on 2016/5/30.
 */
public abstract class BaseFragment extends Fragment {

    private BaseActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        initView(view,savedInstanceState);
        return view;
    }

    protected abstract int getLayoutID();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) mActivity.addFragment(fragment);
    }

    protected void removeFragment() {
        mActivity.removeFragment();
    }
}
