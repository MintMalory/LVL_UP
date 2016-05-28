package ua.mintmalory.levelup_ht1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class B extends AbstractActivity {
    private TextView stackInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        stackInfoTextView = (TextView) findViewById(R.id.b_stackinfo_textview);
        pushToCallStack(getString(R.string.title_activity_b));
        if (stackInfoTextView != null) {
            stackInfoTextView.setText(callStackToString());
        }

        Button nextBtn = (Button) findViewById(R.id.b_nextactivity_btn);

        if (nextBtn != null) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), C.class));
                }
            });
        }
    }
}