package cl.fmunoza.ejemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //boton1=(Button) findViewById(R.id.boton1);

    EditText nombre,telefono;
    Button guardar, listar;
    TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.txtNombre);
        telefono=findViewById(R.id.txtTelefono);

        guardar = findViewById(R.id.btnGuardar);
        listar = findViewById(R.id.btnListar);

        mostrar = findViewById(R.id.TextViewLista);

        DataBase db = new DataBase(this);

        //db.agregarContactos(new Contactos("manuel", "21321321321"));

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.agregarcontactos(new Contactos (nombre.getText().toString(),telefono.getText().toString()));
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Contactos> contacts = db.getAllContactos();
                StringBuilder builder = new StringBuilder();
                for(Contactos cn: contacts){
                    builder.append(
                            "Id: "+cn.getId() + "\n " +
                            "Nombre: "+cn.getNombre() + "\n"+
                            "Telefono: "+ cn.getTelefono()+"\n"+
                            "-----------------------------------"
                            );
                    mostrar.setText(builder);
                }//FALTA ASIGNAR AL TEXTVIEW
            }
        });


    }
}