package com.caijy.jhwei.bv.pedestal;

import com.caijy.jhwei.bv.base.IBaseView;
import com.caijy.jhwei.bv.base.IPresenter;

public interface IMainContract {

    /***********************************
     * MainActivity
     *************************************************/
    interface ILoginView extends IBaseView {

        String getUserName();

        String getUserPassword();

        boolean getIsRememberPw();

        void promptEditNameInput();

        void promptEditPasswordInput();

        void submitSuccessful();
    }

    interface ILoginPresenter extends IPresenter {

        void onSubmitLogin();
    }

    /***********************************
     * SignUpActivity
     *************************************************/
    interface ISignUpView extends IBaseView {

        String getAccountName();

        String getUserPassword();

        String getName();

        String getEmail();

        String getPhone();

        void promptEditNameInput();

        void promptEditPasswordInput();

        void promptNameInput();

        void promptEmailInput();

        void promptPhoneInput();

        void submitSuccessful();
    }

    interface ISignUpPresenter extends IPresenter {

        void onSubmitSignUp();
    }
}
