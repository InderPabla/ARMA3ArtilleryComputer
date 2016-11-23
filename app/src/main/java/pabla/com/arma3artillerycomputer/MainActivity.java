package pabla.com.arma3artillerycomputer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button fireSolutionButton;
    EditText yourXCoordText, yourYCoordText, yourHeight, enemyXCoordText,enemyYCoordText, enemyHeight;
    RadioButton mk6,m4,m5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireSolutionButton = (Button)findViewById(R.id.fireSolution);
        yourXCoordText = (EditText)findViewById(R.id.yourXCoord);
        yourYCoordText = (EditText)findViewById(R.id.yourYCoord);
        yourHeight = (EditText)findViewById(R.id.yourHeight);
        enemyXCoordText = (EditText)findViewById(R.id.enemyXCoord);
        enemyYCoordText = (EditText)findViewById(R.id.enemyYCoord);
        enemyHeight = (EditText)findViewById(R.id.enemyHeight);

        mk6 = (RadioButton)findViewById(R.id.mk6);
        m4 = (RadioButton)findViewById(R.id.m4);
        m5 = (RadioButton)findViewById(R.id.m5);

        ButtonActivity();
    }


    private void ButtonActivity() {
        fireSolutionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Button Test", Toast.LENGTH_SHORT).show();
                int selected = GetSelectedRadio();
                FireSolutionSolver solver = new FireSolutionSolver
                        (
                            Double.parseDouble(yourXCoordText.getText().toString()),
                            Double.parseDouble(yourYCoordText.getText().toString()),
                            Double.parseDouble(yourHeight.getText().toString()),
                            Double.parseDouble(enemyXCoordText.getText().toString()),
                            Double.parseDouble(enemyYCoordText.getText().toString()),
                            Double.parseDouble(enemyHeight.getText().toString()),
                            selected
                        );
            }
        });
    }

    private int GetSelectedRadio() {
        if(mk6.isChecked())
            return 0;
        else if(m4.isChecked())
            return 1;
        else if(m5.isChecked())
            return 2;

        return -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
