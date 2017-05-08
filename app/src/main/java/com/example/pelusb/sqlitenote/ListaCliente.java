package com.example.pelusb.sqlitenote;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cliente cliente = (Cliente) parent.getAdapter().getItem(position);
        ClienteDAO dao = new ClienteDAO(this);
        dao.deletar(cliente.getId());
        Toast.makeText(this, "Cliente "+cliente.getNome()+", excluído!",
                                                Toast.LENGTH_SHORT).show();
    }


}

























