package evt14.bookmaster;

import android.content.Intent;
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
        String Ganrel =  extras.getString("ganre");
        String BookName;
        String BookImage;

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

        c = myDbHelper.query("books",null,"ganre = ?",new String[]{Ganrel},null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            BookName = c.getString(1);
            BookImage = c.getString(4);
            final String forActivity_3 = BookName;

            //RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
            //mainLayout.addView(relativeLayout);

            int resID = getResources().getIdentifier(BookImage , "drawable", getApplicationContext().getPackageName());
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(resID);
            mainLayout.addView(imageView);

            TextView textView = new TextView(getApplicationContext());
            textView.setText(BookName);
            mainLayout.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                 Intent intent = new Intent(getApplicationContext(), Activity_3.class);
                 intent.putExtra("name",forActivity_3);
                 startActivity(intent);

                }
            });

            c.moveToNext();
        }
        c.close();
        myDbHelper.close();
    }
}