package com.example.robertkaczmarek.drogi_bhp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class bhp extends AppCompatActivity {
    double a;
    Double widthRoad;
    RadioGroup vehicles;
    EditText widthMaterial;
    String widthMat;
    Double width;
    Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhp);

    }
    public void counWidthRoad(View view) {


        if (a < 120) {
            widthRoad = 120.00;
        } else {
            widthRoad = a;
        }

        String widthRoad1 = String.format("%.2f", widthRoad);
        Intent go = new Intent(bhp.this, road.class);
        go.putExtra(road.RESULT, widthRoad1);
        startActivity(go);
        widthMaterial = (EditText) findViewById(R.id.widthMaterial);
        widthMaterial.setText("");
        vehicles = (RadioGroup) findViewById(R.id.vehicles);
        vehicles.clearCheck();
    }

    public void Clear(View view) {
        widthMaterial = (EditText) findViewById(R.id.widthMaterial);
        widthMaterial.setText("");
         vehicles = (RadioGroup) findViewById(R.id.vehicles);
        vehicles.clearCheck();

    }


    public void CountRoad(View view) {

      /*  if ( widthMaterial == null){
            Toast.makeText(getApplicationContext(), "Nie poadłeś szerokości transportowanego materiału",
                             Toast.LENGTH_LONG).show();
        }
        else { */
        try{
            widthMaterial = (EditText) findViewById(R.id.widthMaterial);


            widthMat = widthMaterial.getText().toString();
            width = Double.parseDouble(widthMat);

            switch (view.getId()) {
                case R.id.p1:
                    a = width + 30;

                    break;
                case R.id.p2:

                    a = (2 * width) + 60;
                    break;
                case R.id.motorNO1:

                    a = width + 60;
                    break;
                case R.id.motorNo2:

                    a = (2 * width) + 90;
                    break;
                case R.id.motorNo1P:

                    a = width + 90;
                    break;
                case R.id.motorNo2P:

                    a = (2 * width) + 180;
                    break;
                case R.id.motor1:
                    a = width + 60;
                    break;

                case R.id.motor2:

                    a = (2 * width) + 90;
                    break;
                case R.id.motor1P:

                    a = width + 100;
                    break;
                case R.id.motor2P:

                    a = (2 * width) + 200;
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Nie poadłeś szerokości transportowanego materiału",
                    Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.infoItem) {
            Intent i = new Intent(getApplicationContext(), info.class);
            startActivity(i);
            return true;
        }
        else {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
