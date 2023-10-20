package Primer.parcial.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Primer.parcial.Adapters.AdapterUsuario;
import Primer.parcial.Models.Usuario;
import Primer.parcial.R;

public class UsuarioActivity extends AppCompatActivity {

    public static AdapterUsuario adapterUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            toolbar.setTitle(R.string.user_list);
        }
        List<Usuario> listaUsuarios = generarUsuarios();
        adapterUsuario = new AdapterUsuario(listaUsuarios);

        RecyclerView recyclerView = findViewById(R.id.rvUsuario);
        recyclerView.setAdapter(adapterUsuario);

        //Definiendo scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Agregar el DividerItemDecoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public static List<Usuario> generarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        // Añadiendo 10 usuarios a la lista
        usuarios.add(new Usuario("usuario1", "contraseña1", "admin"));
        usuarios.add(new Usuario("usuario2", "contraseña2", "usuario"));
        usuarios.add(new Usuario("usuario3", "contraseña3", "usuario"));
        usuarios.add(new Usuario("usuario4", "contraseña4", "admin"));
        usuarios.add(new Usuario("usuario5", "contraseña5", "usuario"));
        usuarios.add(new Usuario("usuario6", "contraseña6", "admin"));
        usuarios.add(new Usuario("usuario7", "contraseña7", "usuario"));
        usuarios.add(new Usuario("usuario8", "contraseña8", "admin"));
        usuarios.add(new Usuario("usuario9", "contraseña9", "usuario"));
        usuarios.add(new Usuario("usuario10", "contraseña10", "admin"));

        // Imprimiendo la lista de usuarios
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        return usuarios;
    }
}
