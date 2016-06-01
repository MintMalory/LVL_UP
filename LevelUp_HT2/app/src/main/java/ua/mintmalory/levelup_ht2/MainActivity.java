package ua.mintmalory.levelup_ht2;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private final String RED = "red";
    private final String GREEN = "green";
    private final String BLUE = "blue";
    private android.app.FragmentTransaction mFragTrans;
    private MyFragment mRedFragment = new MyFragment(R.color.red_transparent_50);
    private MyFragment mGreenFragment = new MyFragment(R.color.green_transparent_50);
    private MyFragment mBlueFragment = new MyFragment(R.color.blue_transparent_50);
    private CheckBox mRed;
    private CheckBox mGreen;
    private CheckBox mBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRed = (CheckBox) findViewById(R.id.red_checkBox);
        mGreen = (CheckBox) findViewById(R.id.green_checkBox);
        mBlue = (CheckBox) findViewById(R.id.blue_checkBox);

        if (mRed != null) {
            mRed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragTrans = getFragmentManager().beginTransaction();
                    if (mRed.isChecked()) {
                        mFragTrans.add(R.id.fragments, mRedFragment);
                    } else {
                        mFragTrans.remove(mRedFragment);
                    }

                    mFragTrans.addToBackStack(RED);
                    mFragTrans.commit();
                }
            });
        }

        if (mGreen != null) {
            mGreen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mFragTrans = getFragmentManager().beginTransaction();

                    if (mGreen.isChecked()) {
                        mFragTrans.add(R.id.fragments, mGreenFragment);
                    } else {
                        mFragTrans.remove(mGreenFragment);

                    }

                    mFragTrans.addToBackStack(GREEN);
                    mFragTrans.commit();
                }
            });
        }

        if (mBlue != null) {
            mBlue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragTrans = getFragmentManager().beginTransaction();
                    if (mBlue.isChecked()) {
                        mFragTrans.add(R.id.fragments, mBlueFragment);
                    } else {
                        mFragTrans.remove(mBlueFragment);
                    }
                    mFragTrans.addToBackStack(BLUE);
                    mFragTrans.commit();
                }
            });
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (!savedInstanceState.isEmpty()) {
            if (mRed != null) {
                mRed.setChecked(savedInstanceState.getBoolean(RED, false));
            }

            if (mGreen != null) {
                mGreen.setChecked(savedInstanceState.getBoolean(GREEN, false));
            }

            if (mBlue != null) {
                mBlue.setChecked(savedInstanceState.getBoolean(BLUE, false));
            }
        }
    }

    private void invertCheckBox(CheckBox cb) {
        if (cb.isChecked()) {
            cb.setChecked(false);
        } else {
            cb.setChecked(true);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {

            switch (fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName()) {
                case RED:
                    invertCheckBox(mRed);
                    break;
                case GREEN:
                    invertCheckBox(mGreen);
                    break;
                case BLUE:
                    invertCheckBox(mBlue);
                    break;
            }

            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(RED, mRed.isChecked());
        outState.putBoolean(GREEN, mGreen.isChecked());
        outState.putBoolean(BLUE, mBlue.isChecked());
    }
}
