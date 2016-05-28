package ua.mintmalory.levelup_ht1;

import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

public abstract class AbstractActivity extends AppCompatActivity {
    private static Stack<String> CALL_STACK = new Stack<>();

    protected static void pushToCallStack(String activityName) {
        while ((CALL_STACK.contains(activityName))&&(!CALL_STACK.peek().equals(activityName))){
            popFromCallStack();
        }

        if (((CALL_STACK.size() > 0) && (!CALL_STACK.peek().equals(activityName))) || (CALL_STACK.isEmpty())) {
            CALL_STACK.push(activityName);
        }
    }

    private static void popFromCallStack() {
        if (CALL_STACK.size() > 0) {
            CALL_STACK.pop();
        }
    }

    protected String callStackToString() {
        String result = "";

        if (CALL_STACK.size() > 0) {
            for (String e : CALL_STACK) {
                result += e + "->";
            }
            result = result.substring(0, result.length()-2);
        }

        return result;
    }

    @Override
    protected void onPause() {
        if (this.isFinishing()) {
            popFromCallStack();
        }
        super.onPause();
    }
}
