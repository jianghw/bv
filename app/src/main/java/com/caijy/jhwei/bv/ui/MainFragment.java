package com.caijy.jhwei.bv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.util.AnimationUtils;

import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class MainFragment extends BaseFragment{

    public static BaseFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @OnClick({R.id.tv_offline, R.id.tv_sign_up, R.id.tv_forgive_pw})
    public void onTextView(TextView view) {
        AnimationUtils.startShakeByPropertyAnim(view, 0.8f, 1.25f, 2f, 1000);
        switch (view.getId()) {
            case R.id.tv_sign_up:
                addFragment(SignUpFragment.newInstance());
                break;
        }
    }
}
