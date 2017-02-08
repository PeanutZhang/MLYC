package com.peanut.zyh.mlyc.basepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.peanut.zyh.mlyc.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());

      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       mUnbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();

    }
    public abstract int getLayout();
}
