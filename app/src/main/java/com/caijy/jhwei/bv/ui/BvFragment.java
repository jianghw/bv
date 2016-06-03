package com.caijy.jhwei.bv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class BvFragment extends BaseFragment {


    public static BaseFragment newInstance() {
        return new BvFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_bv;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
//        mToolbar.setTitle("");
//        mTvToolbar.setText(getString(R.string.toolbar_title_login));
//        mActivity.setSupportActionBar(mToolbar);

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
