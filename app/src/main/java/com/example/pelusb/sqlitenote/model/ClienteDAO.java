package com.example.pelusb.sqlitenote.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
                "VALUES (?,?)",
                new Object[]{cliente.getNome(), cliente.getEndereco()});
        return false;
    }

    @Override
    public boolean deletar(int id) {
        database.execSQL("DELETE FROM cliente WHERE idcliente=?",
                new Object[]{id});
        return false;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM cliente", null);
        cursor.moveToFirst();
        int indiceColunaId = cursor.getColumnIndex("idcliente");
        int indiceColunaNome = cursor.getColumnIndex("nome");
        int indiceColunaEndereco = cursor.getColumnIndex("endereco");
        do{
           Cliente cliente = new Cliente();
            cliente.setId(cursor.getInt(indiceColunaId));
            cliente.setNome(cursor.getString(indiceColunaNome));
            cliente.setEndereco(cursor.getString(indiceColunaEndereco));

            clientes.add(cliente);
        } while(cursor.moveToNext());
        return clientes;
    }


}

















