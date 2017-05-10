package com.example.pelusb.sqlitenote;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pelusb.sqlitenote.model.Cliente;
import com.example.pelusb.sqlitenote.model.ClienteDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pelusb on 25/04/17.
 */

public class ListaCliente extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.listView);

        atualizaListaClientes();

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Cliente cliente = (Cliente) parent.getAdapter().getItem(position);
        final ClienteDAO dao = new ClienteDAO(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Opção");
        builder.setMessage("Escolha uma opção:");
        builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.chamaTela(ListaCliente.this, cliente);
            }
        });
        builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.deletar(cliente.getId());
                atualizaListaClientes();
                Toast.makeText(ListaCliente.this,
                        "Cliente "+cliente.getNome()+", excluído!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void atualizaListaClientes(){
        ClienteDAO clienteDAO = new ClienteDAO(this);

        List<Cliente> clientes = new ArrayList<>();
        if(clienteDAO.listar()!=null){
            if(clienteDAO.listar().size()>0){
                clientes = clienteDAO.listar();
            }
        }

        ArrayAdapter<Cliente> adapter =
                new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1,
                        clientes);
        listView.setAdapter(adapter);
    }


}

























