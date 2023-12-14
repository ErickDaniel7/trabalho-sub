package com.example.trabalhopaises.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.trabalhopaises.helper.SQLiteDataHelper;
import com.example.trabalhopaises.model.Pais;

import java.util.ArrayList;

public class PaisDao implements GenericDao<Pais> {

    private SQLiteDataHelper openHelper;

    private SQLiteDatabase bd;

    private String tabela = "PAIS";

    private String[]colunas = {"CODIGO", "DESCRICAO"};

        private Context context;

        private static PaisDao instancia;

        private static PaisDao getInstancia(Context context){

            if(instancia == null){
                return instancia = new PaisDao(context);
            }else {
                return instancia;
            }
        }

        private PaisDao (Context context){
            this.context = context;

            openHelper = new SQLiteDataHelper(this.context,"PAISES", null, 1);

            bd = openHelper.getWritableDatabase();
        }

        @Override
         public long insert(Pais obj){
            try {
                ContentValues valores = new ContentValues();
                valores.put("CODIGO", obj.getCodigo());
                valores.put("DESCRICAO", obj.getDescricao());

                return bd.insert(tabela, null, valores);

            }catch (SQLException ex){
                Log.e("ERRO", "PaisDao.insert(): "+ex.getMessage());
            }
            return  0;
        }

        @Override
         public long update(Pais obj){
            try{
                ContentValues valores = new ContentValues();
                valores.put(colunas[1],obj.getCodigo());
                String[]identificador = {String.valueOf(obj.getCodigo())};

                return bd.update(tabela, valores, colunas[0]+"=?", identificador);

            }catch (SQLException ex){
                Log.e("ERRO", "PaisDao.update (): "+ex.getMessage());
            }
                return 0;
        }

        @Override
    public long delete (Pais obj){
            try{
                String[]identificador = {String.valueOf(obj.getCodigo())};
                return  bd.delete(tabela,colunas[0]+" = ?",identificador);
            }catch (SQLException ex){
                Log.e("ERRO", "PaisDao.delete (): "+ex.getMessage());

            }
            return 0;
        }

        public ArrayList<Pais> getAll(){
            ArrayList<Pais> lista = new ArrayList<>();

            try {
                Cursor cursor = bd.query(tabela, colunas, null,null, null, null, colunas[0]);

                if(((Cursor) cursor).moveToFirst()){
                    do{
                        Pais pais = new Pais();

                        pais.setCodigo(cursor.getInt(0));
                        pais.setDescricao(cursor.getString(1));

                        lista.add(pais);
                    }while (cursor.moveToNext());
                }
            }catch (SQLException ex){

                Log.e("ERRO", "PaisDao.getAll(): "+ex.getMessage());
            }

            return  null;
    }

    @Override
        public Pais getById(int codigo){
            try {
                String[]identificador = {String.valueOf(codigo)};
                Cursor cursor = bd.query(tabela,colunas,colunas[0]+" = ?", identificador, null, null, null);

            if(cursor.moveToFirst()){
                Pais pais = new Pais();
                pais.setCodigo(cursor.getInt(0));
                pais.setDescricao(cursor.getString(1));

                return pais;
            }

            }catch (SQLException ex){
                Log.e("ERRO", "PaisDao.getAll(): "+ex.getMessage());
            }

            return  null;
    }
}
