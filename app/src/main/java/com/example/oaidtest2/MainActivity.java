package com.example.oaidtest2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bun.miitmdid.core.MdidSdkHelper;
import com.example.oaidtest2.utils.CertUtil;
import com.example.oaidtest2.utils.SystemInfoUtil;

public class MainActivity extends AppCompatActivity implements MsaHelper.AppIdsUpdater {
    TextView tv_sdk, tv_sys, tv_cert, tv_info;
    Button btn_get_all_ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_sdk = findViewById(R.id.tv_sdk);
        tv_sdk.setText(getSdkVersionInfo());
        tv_sys = findViewById(R.id.tv_sys);
        tv_sys.setText(getSysInfo());
        tv_cert = findViewById(R.id.tv_cert);
        tv_cert.setText(CertUtil.getCertInfo(MsaHelper.loadPemFromAssetFile(this, getPackageName() + MsaHelper.ASSET_FILE_NAME_CERT_SUFFIX)));
        tv_info = findViewById(R.id.tv_info);
        MsaHelper demoHelper = new MsaHelper(this);
        demoHelper.getDeviceIds(this);
        btn_get_all_ids = findViewById(R.id.btn_get_all_ids);
        btn_get_all_ids.setOnClickListener(v -> demoHelper.getDeviceIds(this));
        findViewById(R.id.btn_get_oaid).setOnClickListener(v -> demoHelper.getOAID(this));
        findViewById(R.id.btn_get_vaid).setOnClickListener(v -> demoHelper.getVAID(this));
        findViewById(R.id.btn_get_aaid).setOnClickListener(v -> demoHelper.getAAID(this));

    }


    private String getSdkVersionInfo() {
        return String.format("OAID SDK Test\nVersion: 1.2.1 (%d)", MdidSdkHelper.SDK_VERSION_CODE);
    }

    private String getSysInfo() {
        return String.format("Time: %s\nBrand: %s\nManufacturer: %s\nModel: %s\nAndroidVersion: %s",
                SystemInfoUtil.getSystemTime(),
                SystemInfoUtil.getDeviceBrand(),
                SystemInfoUtil.getDeviceManufacturer(),
                SystemInfoUtil.getSystemModel(),
                SystemInfoUtil.getSystemVersion()
        );
    }

    @Override
    public void onIdsValid(DeviceInfo deviceInfo) {
        runOnUiThread(() -> {
            tv_info.setText(deviceInfo == null ? "deviceInfo：nothing" : deviceInfo.toString());
            tv_sys.setText(getSysInfo());
        });
    }
}