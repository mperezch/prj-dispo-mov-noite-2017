package com.example.pelusb.sqlitenote;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pelusb.sqlitenote.model.Cliente;
import com.example.pelusb.sqlitenote.model.ClienteDAO;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "aula_sqlite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tvNome = (EditText) findViewById(R.id.edtNome);
        final EditText tvEndereco = (EditText) findViewById(R.id.edtEndereco);
        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClienteDAO clienteDAO = new ClienteDAO(MainActivity.this);
                Cliente cliente = new Cliente();
                cliente.setNome(tvNome.getText().toString());
                cliente.setEndereco(tvEndereco.getText().toString());
                clienteDAO.salvar(cliente);

                tvEndereco.setText("");
                tvNome.setText("");
                Toast.makeText(MainActivity.this, "Cliente Salvo!",
                                                Toast.LENGTH_SHORT).show();
            }
        });


    }
}





































/*
try{
        SQLiteDatabase baseDados = openOrCreateDatabase("aula", MODE_PRIVATE, null);
        //tabela
        baseDados.execSQL("CREATE TABLE IF NOT EXISTS cliente(" +
        "idcliente INT AUTO_INCREMENT," +
        "nome VARCHAR(45) NOT NULL," +
        "endereco VARCHAR(45) NOT NULL," +
        "PRIMARY KEY(idcliente)"+
        ");");

        //inserir dados
        baseDados.execSQL("INSERT INTO cliente(nome, endereco) " +
        "VALUES('Pedro','Rua A')");
        baseDados.execSQL("INSERT INTO cliente(nome, endereco) " +
        "VALUES('José','Rua B')");

        //retornando registros
        Cursor cursor =
        baseDados.rawQuery("SELECT nome, endereco FROM cliente", null);
        int indiceColunaNome = cursor.getColumnIndex("nome");
        int indiceColunaEndereco = cursor.getColumnIndex("endereco");

        cursor.moveToFirst();
        while(cursor != null){
        Log.i(TAG, "Nome: " + cursor.getString(indiceColunaNome) +
        ", Endereço: "+ cursor.getString(indiceColunaEndereco));

        cursor.moveToNext();
        }

        } catch (Exception ex){
        Log.e(TAG,ex.getMessage());
        }


*/
















































