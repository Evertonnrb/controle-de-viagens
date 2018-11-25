package com.nrb.nicetrip.subactivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.nrb.nicetrip.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail,edtSenha;
    Button btLogar;
    private CheckBox cbk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtLoginEmail);
        edtSenha = findViewById(R.id.edtLoginSenha);
        btLogar = findViewById(R.id.btLogar);
        cbk = findViewById(R.id.ckbMaterConectado);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });

    }

    /**
     * Valida as condiçoes de login
     * @param email email válido de usuário cadastrado
     * @param senha senha válida de usuário cadastrado
     * @return
     */
   private boolean vaidarLogin(String email,String senha){
        boolean ok = true;

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            ok = false;
            edtEmail.setError(getString(R.string.msg_erro,email));
        }if(!senha.equals("123")){
            ok = false;
            edtSenha.setError(getString(R.string.msg_erro,senha));
       }
       configurarPreferencia();
       return ok;
   }

    /**
     * se true libera o acesso
     */
   private void validar(){
       boolean logar = vaidarLogin(edtEmail.getText().toString(),edtSenha.getText().toString());
       String ms = "";
       if(logar){
           ms = "logado";
       }else{
           ms = "Deslogado";
       }
       Toast.makeText(this,ms,Toast.LENGTH_SHORT).show();
   }

   public void configurarPreferencia(){
       boolean checado = cbk.isChecked();
       if(checado){
           /**TODO
            * Desabilitar a tela de login com SharedPreferences
            */
           Log.i("CKB","Checado");
       }
        Log.i("CKB","Não está checado");
   }

}

