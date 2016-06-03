package com.caijy.jhwei.bv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.caijy.jhwei.bv.R;
import com.caijy.jhwei.bv.base.BaseFragment;
import com.caijy.jhwei.bv.data.Injection;
import com.caijy.jhwei.bv.pedestal.ILoginContract;
import com.caijy.jhwei.bv.presenter.SignUpPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1 0001</br>
 * description:</br>
 */
public class SignUpFragment extends BaseFragment implements ILoginContract.ISignUpView {

    @Bind(R.id.tv_toolbar)
    TextView mTvToolbar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.edit_account)
    EditText mEditAccount;
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    @Bind(R.id.edit_name)
    EditText mEditName;
    @Bind(R.id.edit_email)
    EditText mEditEmail;
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    @Bind(R.id.btn_login)
    AppCompatButton mBtnLogin;

    private ILoginContract.ISignUpPresenter mPresenter;

    public static BaseFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SignUpPresenter(Injection.provideTwoData(), this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_sign_up;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mToolbar.setTitle("");
        mToolbar.setNavigationIcon(R.drawable.ic_title_back);
        mTvToolbar.setText(getString(R.string.toolbar_title_sign_up));
        mActivity.setSupportActionBar(mToolbar);

        //        onTestInputLegitimacy(mEditManager);
        //        onTestInputLegitimacy(mEditPassword);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    private void onTestInputLegitimacy(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() < 6) {
                    promptInput(editText);
                }
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
        mPresenter.onSubmitSignUp();
    }

    @Override
    public String getAccountName() {
        return mEditAccount.getText().toString().trim();
    }

    @Override
    public String getUserPassword() {
        return mEditPassword.getText().toString().trim();
    }

    @Override
    public String getName() {
        return mEditName.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return mEditEmail.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return mEditPhone.getText().toString().trim();
    }

    @Override
    public void promptEditNameInput() {
        //        promptInput(mEditManager);
    }

    @Override
    public void promptEditPasswordInput() {
        promptInput(mEditPassword);
    }

    @Override
    public void promptNameInput() {

    }

    @Override
    public void promptEmailInput() {

    }

    @Override
    public void promptPhoneInput() {

    }

    @Override
    public void submitSuccessful() {
        removeFragment();
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
