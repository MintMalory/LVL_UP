package ua.mintmalory.levelup_ht1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class C extends AbstractActivity {
    private TextView stackInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        stackInfoTextView = (TextView) findViewById(R.id.c_stackinfo_textview);
        pushToCallStack(getString(R.string.title_activity_c));
        if (stackInfoTextView != null) {
            stackInfoTextView.setText(callStackToString());
        }

        Button nextBtn = (Button) findViewById(R.id.c_nextactivity_btn);

        if (nextBtn != null) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), D.class));
                }
            });
        }
    }
}