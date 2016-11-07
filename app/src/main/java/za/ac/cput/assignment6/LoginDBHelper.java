package za.ac.cput.assignment6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sanXion on 2016/11/02.
 */
public class LoginDBHelper extends SQLiteOpenHelper {

    private static final String thisEmail = "email";
    private static final String thisPassword = "password";
    private static final String tableName = "login_details";
    private static final String DATABASE_NAME = "LOGIN.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+tableName+"("+thisEmail+" TEXT,"+
                    thisPassword+" TEXT);";

    public LoginDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPARATIONS", "Database created or open...");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPARATIONS","Table created...");
    }
    //insert data to the database
    public void insertUser(String email,String password,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(thisEmail,email);
        contentValues.put(thisPassword,password);
        db.insert(tableName,null,contentValues);
        Log.e("DATABASE OPARATIONS","Customer inserted...");
    }

    //read data from the database

    public Cursor getCustomer(SQLiteDatabase db)
    {
        Cursor cursor;
        String [] columns = {thisEmail,thisPassword};
        //read and order by name
        cursor = db.query(tableName,columns,null,null,null,null,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
