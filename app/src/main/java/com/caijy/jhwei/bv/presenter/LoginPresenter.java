package com.caijy.jhwei.bv.presenter;

import android.text.TextUtils;

import com.caijy.jhwei.bv.data.Repository;
import com.caijy.jhwei.bv.pedestal.ILoginContract;
import com.caijy.jhwei.bv.ui.LoginFragment;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/6/2 0002</br>
 * description:</br>
 */
public class LoginPresenter implements ILoginContract.ILoginPresenter {

    private final Repository mRepository;
    private final LoginFragment mFragment;
    private final CompositeSubscription mSubscriptions;

    public LoginPresenter(Repository repository, LoginFragment loginFragment) {
        mRepository = repository;
        mFragment = loginFragment;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void onSubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void unSubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void onSubmitLogin() {
        String user = mFragment.getUserName();
        String password = mFragment.getUserPassword();
        if (TextUtils.isEmpty(user) || user.length() < 6) {
            mFragment.promptEditNameInput();
        } else if (TextUtils.isEmpty(password) || password.length() < 6) {
            mFragment.promptEditPasswordInput();
        } else {

        }
    }
}
