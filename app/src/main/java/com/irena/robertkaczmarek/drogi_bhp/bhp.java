package com.irena.robertkaczmarek.drogi_bhp;

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
    String widthRoad1;
    Toast t;
    boolean checked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhp);

    }
    public void CountRoad(View view) {

      /*  if ( widthMaterial == null){
            Toast.makeText(getApplicationContext(), "Nie poadłeś szerokości transportowanego materiału",
                             Toast.LENGTH_LONG).show();
        }
        else { */

        try {
            widthMaterial = (EditText) findViewById(R.id.widthMaterial);
            widthMat = widthMaterial.getText().toString();
            width = Double.parseDouble(widthMat);

                switch (view.getId()) {
                    case R.id.p1:
                        a = width + 30;
                        checked = true;
                        break;
                    case R.id.p2:
                        checked = true;
                        a = (2 * width) + 60;
                        break;
                    case R.id.motorNO1:
                        checked = true;
                        a = width + 60;
                        break;
                    case R.id.motorNo2:
                        checked = true;
                        a = (2 * width) + 90;
                        break;
                    case R.id.motorNo1P:
                        checked = true;
                        a = width + 90;
                        break;
                    case R.id.motorNo2P:
                        checked = true;
                        a = (2 * width) + 180;
                        break;
                    case R.id.motor1:
                        checked = true;
                        a = width + 60;
                        break;

                    case R.id.motor2:
                        checked = true;
                        a = (2 * width) + 90;
                        break;
                    case R.id.motor1P:
                        checked = true;
                        a = width + 100;
                        break;
                    case R.id.motor2P:
                        checked = true;
                        a = (2 * width) + 200;
                        break;
                    default:
                        break;
                }



            } catch(Exception e){

                Toast.makeText(getApplicationContext(), "Nie podałeś szerokości transportowanego materiału",
                        Toast.LENGTH_LONG).show();
                // widthMaterial.setText("");
            vehicles = (RadioGroup) findViewById(R.id.vehicles);
            vehicles.clearCheck();

            }

        }

    public void counWidthRoad(View view) {
        if (widthMaterial != null && checked == true)
             {
            if (a < 120) {
                widthRoad = 120.00;
            } else {
                widthRoad = a;
            }

            widthRoad1 = String.format("%.2f", widthRoad);
            Intent go = new Intent(bhp.this, road.class);
            go.putExtra(road.RESULT, widthRoad1);
            startActivity(go);
            widthMaterial = (EditText) findViewById(R.id.widthMaterial);
            //   widthMaterial.setText("");

            vehicles = (RadioGroup) findViewById(R.id.vehicles);
            vehicles.clearCheck();

        }
        else
        {
           Toast.makeText(getApplicationContext(), "Oznacz rodzaj transportu lub szerokość transportowanego materiału",
                    Toast.LENGTH_LONG).show();
            widthMaterial = (EditText) findViewById(R.id.widthMaterial);


            vehicles = (RadioGroup) findViewById(R.id.vehicles);
           vehicles.clearCheck();
            checked = true;

        }
    }
    public void Clear(View view) {
        widthMaterial = (EditText) findViewById(R.id.widthMaterial);
        widthMaterial.setText("");
         vehicles = (RadioGroup) findViewById(R.id.vehicles);
        vehicles.clearCheck();
            checked = false;
        widthMaterial = null;
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
