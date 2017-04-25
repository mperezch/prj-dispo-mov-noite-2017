package com.example.pelusb.sqlitenote.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pelusb on 18/04/17.
 */

public class ClienteDAO extends GenericDAO<Cliente> {

    private SQLiteDatabase database;

    public ClienteDAO(Context context){
        super(context);
        database = getWritableDatabase();
    }

    @Override
    public boolean salvar(Cliente cliente) {
        database.execSQL("INSERT INTO cliente(nome, endereco) " +
                "VALUES ('"+cliente.getNome()+"'," +
                "'"+cliente.getEndereco()+"')");
        return false;
    }
}
