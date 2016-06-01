package com.caijy.jhwei.bv;

import android.os.Bundle;
import android.view.View;

import com.caijy.jhwei.bv.base.BaseFragment;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class LoginFragment extends BaseFragment {


    public static BaseFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
