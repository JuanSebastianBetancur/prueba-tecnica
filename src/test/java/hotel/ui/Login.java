package hotel.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Login {
    public static final Target BUTTON_LOGIN = Target.the("botón iniciar login") .located(By.id("HeaderControl_Login"));

    public static final Target FIELD_EMAIL_PARENT = Target.the("campo de correo").located(By.id("HeaderControl_LogonControl_LoginFormLayout_txtEmail_CC"));

    public static final Target FIELD_EMAIL = Target.the("campo de correo").located(By.id("HeaderControl_LogonControl_LoginFormLayout_txtEmail_I"));

    public static final Target FIELD_PASSWORD_PARENT = Target.the("campo de password").located(By.id("HeaderControl_LogonControl_LoginFormLayout_txtPassword_CC"));

    public static final Target FIELD_PASSWORD = Target.the("campo de password").located(By.id("HeaderControl_LogonControl_LoginFormLayout_txtPassword_I"));

    public static final Target BUTTON_SUMMIT = Target.the("botón de enviar") .located(By.id("HeaderControl_LogonControl_btnLoginNow_CD"));

    public static final Target FIELD_CAPTCHA = Target.the("campo captcha").located(By.id("HeaderControl_LogonControl_LoginFormLayout_Captcha_TB_I"));

    public static final Target FIELD_CAPTCHA_NOTIFICATION = Target.the("texto captcha").located(By.id("HeaderControl_LogonControl_LoginFormLayout_Captcha_TB_EC"));
}
