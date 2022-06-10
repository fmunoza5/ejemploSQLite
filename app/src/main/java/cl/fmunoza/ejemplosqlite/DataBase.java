package cl.fmunoza.ejemplosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

private static int DATABASE_VERSION=1;
private static String DATABASE_NAME="registros";
private static String TABLA="contactos";
private static String KEY ="id";
private static String NOMBRE ="NOMBRE";
private static String TELEFONO ="telefono";


    public DataBase (Context context){

        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_CONTACTO = "CREATE TABLE " + TABLA +" ("+ KEY + " INTERGER PRIMARY KEY,"+ NOMBRE + " TEXT," + TELEFONO + " TEXT"+ ")";
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLA);
        onCreate(sqLiteDatabase);
    }

    void agregarcontactos(Contactos contactos){
      SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, contactos.getNombre());
        valores.put(TELEFONO, contactos.getTelefono());
        db.insert(TABLA,null,valores);
        db.close();
    }

    void actualizarcontactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, contactos.getNombre());
        valores.put(TELEFONO, contactos.getTelefono());
        db.update(TABLA,valores,KEY + " = ? ", new String[]{String.valueOf(contactos.getId())});
        db.close();
    }

    void eliminarcontactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, contactos.getNombre());
        valores.put(TELEFONO, contactos.getTelefono());
        db.delete(TABLA,KEY + " = ? ", new String[]{String.valueOf(contactos.getId())});
        db.close();
    }

    public List<Contactos> getAllContactos(){

        List<Contactos> listaContactos = new ArrayList<Contactos>();

        String query = "SELECT * FROM "+ TABLA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                Contactos contactos = new Contactos();
                contactos.setId(cursor.getString(0));
                contactos.setNombre(cursor.getString(1));
                contactos.setTelefono(cursor.getString(2));
                listaContactos.add(contactos);
            }while (cursor.moveToNext());
        }
        return listaContactos;
    }

    void actualizarContactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();


    }



}//fin
