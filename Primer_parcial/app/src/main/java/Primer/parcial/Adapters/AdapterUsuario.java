package Primer.parcial.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Primer.parcial.Models.Usuario;
import Primer.parcial.R;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<ViewHolderUsuario> {

    public static List<Usuario> usuarios;
    public AdapterUsuario(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    @Override
    public ViewHolderUsuario onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        return new ViewHolderUsuario(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderUsuario holder, int position) {
        Usuario u = this.usuarios.get(position);
        holder.nombre.setText(u.getNombre());
        holder.tipoUsuario.setText(u.getTipoUsuario());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
    public void updateProducto(int position, Usuario usuario) {
        if (position >= 0 && position < usuarios.size()) {
            usuarios.set(position, usuario);
            notifyDataSetChanged();
        }
    }
}
