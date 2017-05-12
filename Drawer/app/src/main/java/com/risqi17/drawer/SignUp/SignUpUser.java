package com.risqi17.drawer.SignUp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.risqi17.drawer.Login;
import com.risqi17.drawer.R;

public class SignUpUser extends Activity {

    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager. LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_user);

        signin = (TextView)findViewById(R.id.txSignIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioL:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radioP:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
