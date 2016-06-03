package com.caijy.jhwei.bv.pedestal;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.base.FlowTypeActivity;
import com.caijy.jhwei.bv.ui.LoginFragment;
import com.caijy.jhwei.bv.ui.MainFragment;

/**
 * Created by jhwei on 2016/5/30.
 */
public class LoginActivity extends FlowTypeActivity {


    @Override
    protected int getContentViewID() {
        return R.layout.activity_flow_type;
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return LoginFragment.newInstance();
    }

    @Override
    protected int getFragmentContentID() {
        return R.id.aty_fgt_container;
    }

    @Override
    public void onBackPressed() {
        MainFragment fragment = (MainFragment) getSupportFragmentManager()
                .findFragmentByTag(MainFragment.class.getSimpleName());
        if (fragment != null && fragment.isDrawerLayoutOpen()) {
            fragment.closeDrawerLayout();
        } else {
            super.onBackPressed();
        }
    }
}
