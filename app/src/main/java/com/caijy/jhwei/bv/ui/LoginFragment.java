package com.caijy.jhwei.bv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.data.Injection;
import com.caijy.jhwei.bv.pedestal.ILoginContract;
import com.caijy.jhwei.bv.presenter.LoginPresenter;
import com.caijy.jhwei.bv.util.AnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class LoginFragment extends BaseFragment implements ILoginContract.ILoginView {

    @Bind(R.id.tv_toolbar)
    TextView mTvToolbar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.edit_manager)
    EditText mEditManager;
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    @Bind(R.id.cb_remember_pw)
    CheckBox mCbRememberPw;
    @Bind(R.id.tv_forgive_pw)
    TextView mTvForgivePw;
    @Bind(R.id.tv_offline)
    TextView mTvOffline;
    @Bind(R.id.btn_login)
    AppCompatButton mBtnLogin;
    @Bind(R.id.tv_sign_up)
    TextView mTvSignUp;
    private ILoginContract.ILoginPresenter mPresenter;

    public static BaseFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(Injection.provideTwoData(), this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mToolbar.setTitle("");
        mTvToolbar.setText(getString(R.string.toolbar_title_login));
        mActivity.setSupportActionBar(mToolbar);

        isTakePasswordShow();

        onTestInputLegitimacy(mEditManager);
        onTestInputLegitimacy(mEditPassword);
    }

    private void isTakePasswordShow() {

    }

    private void onTestInputLegitimacy(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    promptInput(editText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void promptInput(EditText editText) {editText.setError(getString(R.string.edit_prompt_number));}

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onSubscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }

    @OnClick(R.id.btn_login)
    public void onSubmitLogin() {
        mPresenter.onSubmitLogin();
        //        startActivity(new Intent(mActivity, JhwMainActivity.class));
        addFragment(MainFragment.newInstance());
    }

    @OnClick({R.id.tv_offline, R.id.tv_sign_up, R.id.tv_forgive_pw})
    public void onTextView(TextView view) {
        switch (view.getId()) {
            case R.id.tv_sign_up:
                AnimationUtils.startShakeByPropertyAnim(view, 0.8f, 1.25f, 2f, 1000,
                        new AnimationUtils.AnimationEnd() {
                            @Override
                            public void onStartClickEvent() {
                                addFragment(SignUpFragment.newInstance());
                            }
                        });
                break;
        }
    }

    @Override
    public String getUserName() {
        return mEditManager.getText().toString().trim();
    }

    @Override
    public String getUserPassword() {
        return mEditPassword.getText().toString().trim();
    }

    @Override
    public boolean getIsRememberPw() {
        return mCbRememberPw.isChecked();
    }

    @Override
    public void promptEditNameInput() {
        promptInput(mEditManager);
    }

    @Override
    public void promptEditPasswordInput() {
        promptInput(mEditPassword);
    }

    @Override
    public void submitSuccessful() {
        //TODO
    }

    @Override
    public void showToastMessage(CharSequence charSequence) {

    }

    @Override
    public void loadingDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
