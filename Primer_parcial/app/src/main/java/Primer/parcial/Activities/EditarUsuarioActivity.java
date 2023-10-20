package Primer.parcial.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Primer.parcial.Adapters.AdapterUsuario;
import Primer.parcial.Models.Usuario;
import Primer.parcial.R;
import androidx.appcompat.widget.Toolbar;

public class EditarUsuarioActivity extends AppCompatActivity {
    private EditText editNombre, editContraseña, editTextConfirmarContraseña ;
    private RadioGroup radioGroupeditTipoUsuario;
    private String tipoUsuario;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setTitle(R.string.edit_user);;
        }

        initializeUIComponents();

        int position = getIntent().getIntExtra("position", -1);

        if (position != -1) {

            Usuario usuario = AdapterUsuario.usuarios.get(position);

            populateFields(usuario,position);

        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeUIComponents() {
        editNombre = findViewById(R.id.editTextNombreUsuario);
        editContraseña = findViewById(R.id.editTextContraseña);
        editTextConfirmarContraseña = findViewById(R.id.editTextConfirmarContraseña);
        radioGroupeditTipoUsuario = findViewById(R.id.radioGroupTipoUsuario);
        btnGuardar = findViewById(R.id.buttonGuardar);
    }
    private void populateFields(Usuario usuario, int position) {

        editNombre.setText(usuario.getNombre());
        editContraseña.setText(usuario.getContraseña());
        editTextConfirmarContraseña = findViewById(R.id.editTextConfirmarContraseña);

        setRadioButton(usuario);
        Log.d("Validation", "Antes de validar");
        btnGuardar.setOnClickListener(v -> {
            if (validateInputs()) {
                saveUsuario(usuario, position);
            }
        });
    }
    private boolean validateInputs() {

        String nombreUsuario = editNombre.getText().toString();
        String contraseña = editContraseña.getText().toString();
        String confirmarContraseña = editTextConfirmarContraseña.getText().toString();
        Log.d("Validation", nombreUsuario);
        if (nombreUsuario.length() < 3) {
            Toast.makeText(this, "El nombre de usuario debe tener al menos 3 caracteres.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!contraseña.equals(confirmarContraseña)) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setRadioButton(Usuario usuario) {
        switch (usuario.getTipoUsuario()) {
            case "administrador":
                radioGroupeditTipoUsuario.check(R.id.radioButtonAdmin);
                break;
            case "usuario":
                radioGroupeditTipoUsuario.check(R.id.radioButtonUsuario);
                break;
        }
    }
    private void saveUsuario(Usuario usuario, int position) {
        usuario.setNombre(editNombre.getText().toString());
        usuario.setContraseña(editContraseña.getText().toString());

        int selectedId = radioGroupeditTipoUsuario.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            tipoUsuario = selectedRadioButton.getTag().toString();
            usuario.setTipoUsuario(tipoUsuario);
        }

        UsuarioActivity.adapterUsuario.updateProducto(position, usuario);
        Toast.makeText(this, "Usuario registrado correctamente.", Toast.LENGTH_SHORT).show();
        finish();
        Log.d("Event", "Finalizar Guardar - OK");
    }

}
