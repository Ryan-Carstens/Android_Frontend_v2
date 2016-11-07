package za.ac.cput.assignment6;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import za.ac.cput.assignment6.model.LoginDetails;

public class ViewUserActivity extends Activity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    LoginDBHelper loginDBHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        listView = (ListView)findViewById(R.id.listView_User);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter );
        loginDBHelper = new LoginDBHelper(getApplicationContext());
        sqLiteDatabase = loginDBHelper.getReadableDatabase();
        cursor = loginDBHelper.getCustomer(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do
            {

                String email,password;
                email = cursor.getString(0);
                password = cursor.getString(1);

                LoginDetails dataAdapter = new LoginDetails(email,password);

                listDataAdapter.add(dataAdapter);

            }while (cursor.moveToNext());
        }
    }
}
