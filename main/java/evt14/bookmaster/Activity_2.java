package evt14.bookmaster;

import android.database.Cursor;
import android.database.SQLException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        String BookName;
        int BookImage;

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

         LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainlayout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

/*      c = myDbHelper.query("Books",null,"Ganre = ?",new String[]{Ganrel},null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            BookName = c.getString(1);
            BookImage = c.getInt(4);

            RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
            mainLayout.addView(relativeLayout);

            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(BookImage);
            relativeLayout.addView(imageView);

            TextView textView = new TextView(getApplicationContext());
            textView.setText(BookName);
            relativeLayout.addView(textView);

            c.moveToNext();
        }
        c.close();
*/      myDbHelper.close();
    }
}