package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import za.ac.cput.assignment6.model.RegistryManager;
import za.ac.cput.assignment6.services.Impl.LoginServiceImpl;

public class LoginActivity extends Activity {

    private EditText username;
    private EditText password;
    private Button login;
    private boolean isValid = false;
    private RegistryManager registryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }

    public void login()
    {
        //cater for sub instances
        Intent subIntentExtras = getIntent();
        Bundle subExtras = subIntentExtras.getExtras();
        String subUsername = null;
        try {
            subUsername = subExtras.getString("Username");
        }
        catch (NullPointerException e)
        {
            subUsername = null;
        }


        //get data
        login = (Button)findViewById(R.id.btnLogin);
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        if(subUsername != null)
        {
            username.setText(subUsername);
            password.requestFocus();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals(""))
                {
                    username.requestFocus();
                    username.setError("Cannot be empty.");
                }else if (password.getText().toString().equals(""))
                {
                    password.requestFocus();
                    password.setError("Cannot be empty.");
                }else {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            LoginServiceImpl service = new LoginServiceImpl();
                            if(service.loginRegistryManager(username.getText().toString(),password.getText().toString()))
                            {
                                isValid = true;

                            }else
                            {
                                isValid = false;
                            }
                        }
                    });
                    thread.start();
                    try
                    {
                        thread.join();
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    if(!isValid) {
                        username.requestFocus();
                        username.setError("Username or Password is incorrect.");
                        password.setError("Username or Password is incorrect.");
                    }
                    else{
                        Intent openStep = new Intent(LoginActivity.this, homeActivity.class);
                        //PASS USER DETAILS
                        openStep.putExtra("username",username.getText().toString());
                        startActivity(openStep);
                    }
                }
            }
        });
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.buttonSignup:
                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup);
                break;
            case R.id.buttonBack:
                Intent back = new Intent(LoginActivity.this, homeActivity.class);
                startActivity(back);
                break;
        }

    }
}
