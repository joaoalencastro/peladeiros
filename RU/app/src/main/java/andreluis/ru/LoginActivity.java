package andreluis.ru;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {


    protected Button mConsultarButton;   // Botão que tem função de consulta do nome de matrícula + senha
    protected EditText mCampoMatricula, mCampoSenha;
    protected String matricula, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       Context contexto = getApplicationContext(); //(??) --Necessario para funcionamento do toast

        mConsultarButton = (Button) findViewById(R.id.button);
        mCampoMatricula = (EditText) findViewById(R.id.CampoMatricula);
        mCampoSenha = (EditText) findViewById(R.id.CampoSenha);

        String texto_toast = "Matrícula ou senha incorretos";
        int duracao = Toast.LENGTH_LONG;

        final Toast toast = Toast.makeText(contexto, texto_toast, duracao); // Toast garante a exibição da mensagem de erro
                                                                            // ao ser inserida matrícula ou senha errados


        View.OnClickListener listener = new View.OnClickListener(){         // O que fazer quando o botão é clicado

            public void onClick(View view){


                matricula = mCampoMatricula.getText().toString();
                senha = mCampoSenha.getText().toString();

                if(matricula.equals("2016") && senha.equals("123456")){

                    startActivityHome(view);

                }
                else{

                    toast.show();  //Exibe mensagem de erro


                }
            }

        };

        mConsultarButton.setOnClickListener(listener);

    }

    public void startActivityHome(View view) {

        Intent homeActivity = new Intent(this, HomeActivity.class);
        startActivity(homeActivity);
    }

}
