package com.caijy.jhwei.bv.base;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by jhwei on 2016/5/30.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 添加
     *
     * @param fragment
     */
    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(getFragmentContentID(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    protected abstract int getFragmentContentID();

    /**
     * 手动回退
     */
    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode && getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
