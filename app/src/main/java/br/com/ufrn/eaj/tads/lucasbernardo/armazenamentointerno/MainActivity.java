package br.com.ufrn.eaj.tads.lucasbernardo.armazenamentointerno;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String FILENAME = "hello_file";
    String string = "hello world!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onClick(View v) throws IOException {

        // Read File and Content
        FileInputStream fin = openFileInput(FILENAME);
        int size;
        String newText = "";

        // read inside if it is not null (-1 means empty)
        while ((size = fin.read()) != -1) {
            // add & append content
            newText += Character.toString((char) size);
        }
            fin.close();

            Toast.makeText(this, newText, Toast.LENGTH_SHORT).show();
    }
}
