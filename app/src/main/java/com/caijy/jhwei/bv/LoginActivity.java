package com.caijy.jhwei.bv;

import com.caijy.jhwei.bv.base.FlowTypeActivity;
import com.caijy.jhwei.bv.base.BaseFragment;

/**
 * Created by jhwei on 2016/5/30.
 */
public class LoginActivity extends FlowTypeActivity {


    @Override
    protected BaseFragment getFirstFragment() {
        return LoginFragment.newInstance();
    }
}
