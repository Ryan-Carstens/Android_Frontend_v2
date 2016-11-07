package za.ac.cput.assignment6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.buttonListView:
                Intent listView = new Intent(homeActivity.this, ViewUserActivity.class);
                startActivity(listView);
                break;
            case R.id.btnLoginHome:
                Intent login = new Intent(homeActivity.this, LoginActivity.class);
                startActivity(login);
                break;
            case R.id.button_signup:
                Intent signup = new Intent(homeActivity.this, SignUpActivity.class);
                startActivity(signup);
                break;
            case R.id.buttonExitApp:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                break;
        }

    }
}
