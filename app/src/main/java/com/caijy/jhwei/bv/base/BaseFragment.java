package com.caijy.jhwei.bv.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.caijy.jhwei.bv.R;

import butterknife.ButterKnife;

/**
 * Created by jhwei on 2016/5/30.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    private ProgressDialog mProgressDialog;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (BaseActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        ButterKnife.bind(this, view);
        initView(view,savedInstanceState);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        dismissLoadingDialog();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected abstract int getLayoutID();

    protected abstract void initView(View view, Bundle savedInstanceState);

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) mActivity.addFragment(fragment);
    }

    protected void removeFragment() {
        mActivity.removeFragment();
    }

    protected void createLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mActivity,ProgressDialog.THEME_HOLO_DARK);
            mProgressDialog.setMessage(getString(R.string.send_net_request));
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();

            WindowManager.LayoutParams params = mProgressDialog.getWindow().getAttributes();
            params.alpha=0.9f;
            params.gravity= Gravity.CENTER;
            params.dimAmount = 0.4f;
            mProgressDialog.getWindow().setAttributes(params);
        }
    }

    protected void dismissLoadingDialog() {
        if (null != mProgressDialog && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
