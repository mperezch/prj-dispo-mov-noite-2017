package com.example.pelusb.sqlitenote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pelusb.sqlitenote.model.Cliente;
import com.example.pelusb.sqlitenote.model.ClienteDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pelusb on 25/04/17.
 */

public class ListaCliente extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView listView = (ListView) findViewById(R.id.listView);

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

























