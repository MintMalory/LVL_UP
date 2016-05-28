package ua.mintmalory.levelup_ht1;

import android.os.Bundle;
import android.widget.TextView;

public class D extends AbstractActivity {

    private TextView stackInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        stackInfoTextView = (TextView) findViewById(R.id.d_stackinfo_textview);
        pushToCallStack(getString(R.string.title_activity_d));
        if (stackInfoTextView != null) {
            stackInfoTextView.setText(callStackToString());
        }

    }
}