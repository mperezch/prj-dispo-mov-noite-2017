package com.example.pelusb.sqlitenote.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public abstract class GenericDAO<T> extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "aula_disp2";
    private static final int VERSAO_BANCO = 2;
    private String sqlCreateCliente = "CREATE TABLE IF NOT EXISTS cliente(" +
            "idcliente INT AUTO_INCREMENT," +
            "nome VARCHAR(45) NOT NULL," +
            "endereco VARCHAR(45) NOT NULL," +
            "cpf CHAR(11)," +
            "PRIMARY KEY(idcliente)"+
            ");";

    public GenericDAO(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateCliente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2)
            db.execSQL("ALTER TABLE cliente ADD COLUMN cpf CHAR(11)");
    }

    public abstract  boolean salvar(T t);
    public abstract List<T> listar();
    public abstract  boolean deletar(int id);

}




























