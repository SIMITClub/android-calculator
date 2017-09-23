package a2017.simitclub.com.calculator;

        import android.os.Bundle;
        import android.app.Activity;
        import android.util.Log;
        import android.view.View;
        import android.widget.GridView;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Switch;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends Activity {
    String msg = "Android : ";
    TextView calculationView;
    TextView resultView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationView = (TextView) findViewById(R.id.opertationView);
        resultView =  (TextView) findViewById(R.id.result);
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    /** Called to concat the calculations and calculate*/
    public void AppendOperator(View v)
    {
        String currentText = ((TextView) v).getText().toString();
        calculationView.append(currentText);
    }

    public void OperateCalculation(View v)
    {
        String currentText = ((TextView) v).getText().toString();
        calculationView.append(currentText);
        Compute(v);
    }

    /** Compute the whole expression
     * 3 and 2 operands
     * + operator */
    public void Compute(View v) {
        double result = 0.0;
        String[] numbers = calculationView.getText().toString().split("\\+");

        for (int i = 0; i < numbers.length; i++) {
            result += Integer.parseInt(numbers[i]);
        }

        resultView.setText(String.format("%s", result));
    }

    /** This method will clear the view and calculations*/
    public void Clear(View v)
    {
        calculationView.setText("");
        Toast.makeText(getApplicationContext(),
                "Cleared Calculations", Toast.LENGTH_SHORT).show();
    }
}