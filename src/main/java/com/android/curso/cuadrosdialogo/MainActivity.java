package com.android.curso.cuadrosdialogo;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        respuesta=(TextView)findViewById(R.id.respuestaTextView);
        Button dialogButton=(Button)findViewById(R.id.verDialogButton);
        dialogButton.setOnClickListener(this);

        Button button=(Button) findViewById(R.id.intentActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent("com.telefonica.sample.testaction", Uri.parse("http://com.example")));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            }
        });

            }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alert =new AlertDialog.Builder(this);

        //AlertDialog alertDialog=new AlertDialog();
        alert.setMessage("titulo alerta");
        alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.respuesta.setText("ha pulsado ok");
            }
        });
        alert.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.this.respuesta.setText("ha pulsado cancel");
            }
        });

        alert.setIcon(R.drawable.ic_launcher_background);
        alert.show();

      /*  alert.setMessage("este es la prueba").setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.respuesta.setText("ha pulsado ok");
            }
        }).show();
*/
    }
}
