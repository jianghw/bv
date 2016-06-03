package com.caijy.jhwei.bv.pedestal;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.base.FlowTypeActivity;
import com.caijy.jhwei.bv.ui.MainFragment;

/**
 * Created by jhwei on 2016/5/30.
 */
public class JhwMainActivity extends FlowTypeActivity{

    @Override
    protected int getContentViewID() {
        return R.layout.activity_same_type;
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }

    @Override
    protected int getFragmentContentID() {
        return R.id.aty_fgt_container_2;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
