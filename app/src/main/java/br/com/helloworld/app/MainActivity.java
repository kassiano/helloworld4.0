package br.com.helloworld.app;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Context context;
    TextToSpeech speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;


        speech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speech.setLanguage(Locale.UK);
                }
            }
        });


        //declaração das variaveis
        Button btn_hello;
        final TextView text_hello;
        final EditText edit_hello;


        //buscando os componentes no layout e preenchendo as variaveis
        btn_hello = (Button)findViewById(R.id.btn_say_hello);
        text_hello = (TextView) findViewById(R.id.text_hello);
        edit_hello =(EditText) findViewById(R.id.edit_hello);


        btn_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = edit_hello.getText().toString();
                text_hello.setText(texto);

                //Criando o objeto Toast
                Toast.makeText(context, texto, Toast.LENGTH_LONG).show();

                //metodo speak que vai pronunciar o texto passado
                speech.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }
}
