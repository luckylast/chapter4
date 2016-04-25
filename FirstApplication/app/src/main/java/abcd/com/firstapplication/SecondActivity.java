package abcd.com.firstapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by amyhan on 10/05/15.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
    }
}
