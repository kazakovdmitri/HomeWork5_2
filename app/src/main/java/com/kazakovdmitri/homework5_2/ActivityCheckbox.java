package com.kazakovdmitri.homework5_2;//package com.kazakovdmitri.homework5_2;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kazakovdmitri.homework5_2.R;

public class ActivityCheckbox extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        initViews();
    }

    private void initViews(){
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            mBankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mMobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            mCashAddressChkBx.setChecked(true);
                            break;
                        default:
                    }
                }
            }
        };
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputMoney.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityCheckbox.this, R.string.empty_money, Toast.LENGTH_SHORT).show();
                }
                if (mInputInfo.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityCheckbox.this, R.string.empty_info, Toast.LENGTH_SHORT).show();
                }
                if (mBankCardChkBx.isChecked()) {
                    String summ = mInputMoney.getText().toString();
                    String info = mInputInfo.getText().toString();
                    String result = getResources().getString(R.string.result_card, summ, info);
                    Toast.makeText(ActivityCheckbox.this, result, Toast.LENGTH_LONG).show();
                } else if (mMobilePhoneChkBx.isChecked()) {
                    String summ = mInputMoney.getText().toString();
                    String info = mInputInfo.getText().toString();
                    String result = getResources().getString(R.string.result_phone, summ, info);
                    Toast.makeText(ActivityCheckbox.this, result, Toast.LENGTH_LONG).show();
                } else if (mCashAddressChkBx.isChecked()) {
                    String summ = mInputMoney.getText().toString();
                    String info = mInputInfo.getText().toString();
                    String result = getResources().getString(R.string.result_address, summ, info);
                    Toast.makeText(ActivityCheckbox.this, result, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ActivityCheckbox.this, R.string.result_empty, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void resetCheckBoxes() {
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
        mInputInfo.setText("");
    }
}
