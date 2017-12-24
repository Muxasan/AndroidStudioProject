package evt14.bookmaster;

import android.app.Activity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.SQLException;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class Activity_3 extends Activity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Bundle extras = getIntent().getExtras();
        String name =  extras.getString("name");
        String text;

        DatabaseHelper myDbHelper = new DatabaseHelper(getApplicationContext());
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        ScrollView scrollLayout = (ScrollView) findViewById(R.id.mailayout);

        c = myDbHelper.query("books",null,"name = ?",new String[]{name},null,null,null);
        c.moveToFirst();
        text = c.getString(3);
        TextView textView = new TextView(getApplicationContext());
        textView.setText(text);
        scrollLayout.addView(textView);

        c.close();
        myDbHelper.close();
    }
}
