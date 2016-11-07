package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {

    private EditText user_email;
    private EditText user_password;
    private EditText user_confirmPassword;
    private String userExists = "";
    Context context = this;
    LoginDBHelper loginDBHelper;
    SQLiteDatabase sqLiteDatabase;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user_email = (EditText)findViewById(R.id.email);
        user_password = (EditText)findViewById(R.id.password);
        user_confirmPassword = (EditText)findViewById(R.id.confirmPassword);
    }

    public void backClick(View view){
        switch (view.getId())
        {
            case R.id.buttonBack:
                Intent backHome = new Intent(SignUpActivity.this, homeActivity.class);
                startActivity(backHome);
                break;
        }

    }

    public void Register(View view)
    {
        final String Email = user_email.getText().toString();
        final String Password = user_password.getText().toString();
        final String ConfirmPassword = user_confirmPassword.getText().toString();

        if(Email.equals(""))
        {
            user_email.requestFocus();
            user_email.setError("Cannot be empty.");
        }
        else if(Password.equals(""))
        {
            user_password.requestFocus();
            user_password.setError("Cannot be empty.");
        }
        else if(Password.length() < 8 || !Password.matches(".*\\d+.*") || !Password.matches(".*[a-zA-Z]+.*"))
        {
            user_password.requestFocus();
            user_password.setError("Password must have 8 or more characters.\nPassword must have numbers.");
        }
        else if(ConfirmPassword.equals(""))
        {
            user_confirmPassword.requestFocus();
            user_confirmPassword.setError("Cannot be empty.");
        }
        else if(!ConfirmPassword.equals(Password))
        {
            user_confirmPassword.requestFocus();
            user_confirmPassword.setError("Passwords do not match!");
        }
        else
        {
            loginDBHelper = new LoginDBHelper(context);
            sqLiteDatabase = loginDBHelper.getWritableDatabase();
            loginDBHelper.insertUser(Email, Password, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
            loginDBHelper.close();
            user_email.setText("");
            user_password.setText("");
            user_confirmPassword.setText("");
        }
    }

}

