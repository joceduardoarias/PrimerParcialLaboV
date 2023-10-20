package Primer.parcial.Adapters;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import Primer.parcial.Activities.EditarUsuarioActivity;
import Primer.parcial.R;
public class ViewHolderUsuario extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView nombre, contraseña, tipoUsuario;

    public ViewHolderUsuario(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this::onClick);
        nombre = itemView.findViewById(R.id.nombre);
        tipoUsuario = itemView.findViewById(R.id.tipoUsuario);

    }

    @Override
    public void onClick(View v) {
        // Obtener la posición del ítem clickeado
        int position = getAbsoluteAdapterPosition();

       if (position != RecyclerView.NO_POSITION) {
            // Crear un Intent para iniciar activityEditarUsario
            Intent intent = new Intent(v.getContext(), EditarUsuarioActivity.class);
            // enviar la posición del ítem para buscar el usuario en una lista
            intent.putExtra("position", position);

            // Iniciar EditarProductoActivity
            v.getContext().startActivity(intent);

            Log.d("ITEM", "onClick: " + position);

        }
    }
}
