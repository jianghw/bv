package com.caijy.jhwei.bv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.custom.ProjectItemView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class MainFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {


    @Bind(R.id.tv_toolbar)
    TextView mTvToolbar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.project_bv)
    ProjectItemView mProjectBv;
    @Bind(R.id.project_rheumatoid)
    ProjectItemView mProjectRheumatoid;
    @Bind(R.id.project_collaurum)
    ProjectItemView mProjectCollaurum;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    public static BaseFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mToolbar.setTitle("");
        mTvToolbar.setText(getString(R.string.toolbar_title_main));
        mActivity.setSupportActionBar(mToolbar);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mActivity,
                mDrawerLayout,
                mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @OnClick({R.id.project_bv, R.id.project_rheumatoid, R.id.project_collaurum})
    public void onClickItem(ProjectItemView view) {
        switch (view.getId()) {
            case R.id.project_bv:
                addFragment(BvFragment.newInstance());
                break;
            case R.id.project_rheumatoid:
                break;
            case R.id.project_collaurum:
                break;
            default:
                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public boolean isDrawerLayoutOpen() {
        if (getView() == null) return false;
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    public void closeDrawerLayout() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

}
