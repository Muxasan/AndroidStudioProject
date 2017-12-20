package evt14.bookmaster;

import android.database.Cursor;
import android.database.SQLException;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Activity_2 extends Activity {

    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle extras = getIntent().getExtras();
        String Ganrel =  extras.getString("Ganre");
        String BookName = "";
        String BookImage = "";

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

        RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.mainlayout);

        c = myDbHelper.query("Books",null,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            BookName = c.getString(1);
            BookImage = c.getString(4);

            int resID = getResources().getIdentifier(BookImage , "drawable", getPackageName());
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(resID);
            mainLayout.addView(imageView);

            TextView textView = new TextView(getApplicationContext());
            textView.setText(BookName);
            mainLayout.addView(textView);

            c.moveToNext();
        }
        c.close();
        myDbHelper.close();
    }
}