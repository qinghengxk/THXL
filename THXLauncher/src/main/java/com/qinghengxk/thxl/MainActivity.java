package com.qinghengxk.thxl;


import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.qinghengxk.thxl.Fragment.DownloadPreviewFragment;
import com.qinghengxk.thxl.Fragment.HomeFragment;
import com.qinghengxk.thxl.Fragment.SettingPreviewFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button home = this.findViewById(R.id.home);
        Button download = this.findViewById(R.id.download);
        Button settings = this.findViewById(R.id.settings);
        home.setOnClickListener(this);
        download.setOnClickListener(this);
        settings.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.download:
                replaceFragment(new DownloadPreviewFragment());
                break;
            case R.id.settings:
                replaceFragment(new SettingPreviewFragment());
        }
    }



    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.preview, fragment);
        fragmentTransaction.commit();
    }

}