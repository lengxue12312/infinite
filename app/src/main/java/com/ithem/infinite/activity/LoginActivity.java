package com.ithem.infinite.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ithem.infinite.ContactValue.ContactValue;
import com.ithem.infinite.R;
import com.ithem.infinite.Utils.LoginUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_pass;
    private String mEmailAddress;
    private String mEmailpass;
    private CheckBox cb_remeber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        cb_remeber = (CheckBox) findViewById(R.id.cb_remeber);
        String mSpEmailaddress = LoginUtil.getString(this, ContactValue.EMAILADDRESS, "");
        String mSpEmailpass = LoginUtil.getString(this, ContactValue.EMAILPASS, "");
        boolean mRember = LoginUtil.getBoolean(this, ContactValue.REMBER, false);
        et_name.setText(mSpEmailaddress);
        et_pass.setText(mSpEmailpass);
        cb_remeber.setChecked(mRember);
        cb_remeber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LoginUtil.putBoolean(getApplicationContext(), ContactValue.REMBER, isChecked);
            }
        });

    }

    public void login(View v) {
        mEmailAddress = et_name.getText().toString().trim();
        mEmailpass = et_pass.getText().toString().trim();
        boolean rember = LoginUtil.getBoolean(this, ContactValue.REMBER, false);
        String emailaddress = LoginUtil.getString(this, ContactValue.EMAILADDRESS, "");
        String emailpass = LoginUtil.getString(this, ContactValue.EMAILPASS, "");
        if (!TextUtils.isEmpty(mEmailAddress) && !TextUtils.isEmpty(mEmailpass)) {
            if (rember) {
                if (TextUtils.isEmpty(emailaddress) || TextUtils.isEmpty(emailpass)) {
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    LoginUtil.putString(this, ContactValue.EMAILADDRESS, mEmailAddress);
                    LoginUtil.putString(this, ContactValue.EMAILPASS, mEmailpass);
                    LoginUtil.putBoolean(this, ContactValue.REMBER, rember);
                } else if (!TextUtils.isEmpty(emailaddress)&&!TextUtils.isEmpty(emailpass)){
                    if (emailaddress.equals(mEmailAddress) && emailpass.equals(mEmailpass)) {
                        Intent intent = new Intent(this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "邮箱或密码不正确", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "请记住密码", Toast.LENGTH_SHORT).show();
            }
        } else if (TextUtils.isEmpty(mEmailpass) | TextUtils.isEmpty(mEmailpass)) {
            Toast.makeText(this, "邮箱或密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

}
