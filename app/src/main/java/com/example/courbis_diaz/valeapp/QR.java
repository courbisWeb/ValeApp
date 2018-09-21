package com.example.courbis_diaz.valeapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class QR extends AppCompatActivity {

    private CameraSource cameraSource;
    private SurfaceView cameraView;
    private final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private String token = "";
    private TextView textViewRut;
    private TextView textViewNombre;
    private TextView textViewCargo;
    private TextView textViewEmpresa;
    private TextView textViewNombreEmpresa;
    private Button btnQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lector_qr);
        textViewRut=(TextView)findViewById(R.id.textViewRut);
        textViewNombre=(TextView)findViewById(R.id.textViewNombreColaborador);
        textViewCargo=(TextView)findViewById(R.id.textViewCargoColaborador);
        textViewEmpresa=(TextView)findViewById(R.id.textViewEmpresaColaborador);
        textViewNombreEmpresa=(TextView)findViewById(R.id.textViewNombreEmpresaColaborador);
        btnQR=(Button)findViewById(R.id.buttonQR);
        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (token.length()>0){
                if(token.equals("18.356.676-8")){
                    textViewRut.setText(token);
                    textViewNombre.setText("Julio Courbis");
                    textViewCargo.setText("Yesero");
                    textViewEmpresa.setText("Contratista");
                    textViewNombreEmpresa.setText("Courbis Diaz Limitada");
                }}else{
                    Toast.makeText(QR.this, "Vuelve a enfocar el codigo QR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cameraView = (SurfaceView) findViewById(R.id.camera_view);
        initQR();
    }

    public void initQR() {

        // creo el detector qr
        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.ALL_FORMATS)
                        .build();

        // creo la camara
        cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1600, 1024)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        // listener de ciclo de vida de la camara
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                // verifico si el usuario dio los permisos para la camara
                if (ActivityCompat.checkSelfPermission(QR.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        // verificamos la version de ANdroid que sea al menos la M para mostrar
                        // el dialog de la solicitud de la camara
                        if (shouldShowRequestPermissionRationale(
                                Manifest.permission.CAMERA)) ;
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                MY_PERMISSIONS_REQUEST_CAMERA);
                    }
                    return;
                } else {
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException ie) {
                        Log.e("CAMERA SOURCE", ie.getMessage());
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        // preparo el detector de QR
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }


            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() > 0) {

                    // obtenemos el token
                    token = barcodes.valueAt(0).displayValue.toString();
                    Log.d("mensaje","Este es el maldito token= "+token);
                    Toast.makeText(QR.this, "Hola MDF", Toast.LENGTH_SHORT).show();
                    cameraSource.stop();
                }


            }
        });

    }

    public void MSG(){
        Toast.makeText(QR.this, "Hola MDF", Toast.LENGTH_SHORT).show();
    }
}
