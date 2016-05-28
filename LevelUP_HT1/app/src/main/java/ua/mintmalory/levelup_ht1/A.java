package ua.mintmalory.levelup_ht1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A extends AbstractActivity {
    private TextView stackInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        this.setTitle(getString(R.string.title_activity_a));

        pushToCallStack(getString(R.string.title_activity_a));

        stackInfoTextView = (TextView) findViewById(R.id.a_stackinfo_textview);
        if (stackInfoTextView != null) {
            stackInfoTextView.setText(callStackToString());
        }

        Button nextBtn = (Button) findViewById(R.id.a_nextactivity_btn);

        if (nextBtn != null) {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), B.class));
                }
            });
        }
    }
}
