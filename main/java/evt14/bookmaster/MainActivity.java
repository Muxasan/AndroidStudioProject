package evt14.bookmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView categories = (TextView) findViewById(R.id.categories);
        Button buttonRC = (Button) findViewById(R.id.buttonRC);
        Button buttonD = (Button) findViewById(R.id.buttonD);
        Button buttonF = (Button) findViewById(R.id.buttonF);
        Button buttonP = (Button) findViewById(R.id.buttonP);

        buttonRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                intent.putExtra("Ganre","Русская классика");
                startActivity(intent);
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                intent.putExtra("Ganre","Детектив");
                startActivity(intent);
            }
        });
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                intent.putExtra("Ganre","Фэнтези");
                startActivity(intent);
            }
        });
        buttonP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                intent.putExtra("Ganre","Приключения");
                startActivity(intent);
            }
        });
    }
}
