package com.example.greiv.sensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private Socket cliente;
    private BufferedReader entrada;
    private PrintWriter salida;
    private String ip = "192.168.0.20";
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensor == null) {
            finish();
        }
        Button fire = (Button) findViewById(R.id.FIRE);
        fire.setOnClickListener(this);
        sensorEventListener = new SensorEventListener() {
            /**
             * Metodo que dependiendo de la posicion en "y" (acelerometro) conecta con el servidor y envia un mensaje para decir su posicion
             * @param sensorEvent
             */
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float y = sensorEvent.values[1];
                if(y < -1.5){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    try {
                        cliente = new Socket(ip, 8000);
                        salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);
                        salida.println(1);
                        cliente.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else if(y > 1.5){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    try {
                        cliente = new Socket(ip, 8000);
                        salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);
                        salida.println(2);
                        cliente.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                    try {
                        cliente = new Socket(ip, 8000);
                        salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);
                        salida.println(0);
                        cliente.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }

    private void start(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    /**
     * metodo el cual actua al presionar el boton,  conecta al servidor y envia señal para disparar
     * @param view
     */
    @Override
    public void onClick(View view) {
        try {
            cliente = new Socket(ip, 8000);
            salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()), true);
            salida.println(20);
            cliente.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}