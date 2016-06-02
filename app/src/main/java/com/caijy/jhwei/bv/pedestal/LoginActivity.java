package com.caijy.jhwei.bv.pedestal;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.FlowTypeActivity;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.ui.LoginFragment;

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
}
