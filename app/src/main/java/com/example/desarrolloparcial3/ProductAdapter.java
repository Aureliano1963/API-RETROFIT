package com.example.desarrolloparcial3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desarrolloparcial3.databinding.ItemProductoBinding;
import com.example.desarrolloparcial3.models.Producto;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Producto> productos;
    private Activity context;
    public ProductAdapter(Activity context, List<Producto> productos){
        this.context = context;
        this.productos = productos;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(productos.get(position) );
    }
    @Override
    public int getItemCount() {
        return productos != null ? productos.size() : 0;
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {
        private ItemProductoBinding itemProductoBinding;
        public ProductViewHolder(View view) {
            super(view);
            itemProductoBinding = ItemProductoBinding.bind(view);
        }
        public void bind(Producto producto) {
            itemProductoBinding.tvCodigo.setText(     "Código      : "  + producto.getCodigo());
            itemProductoBinding.tvDescripcion.setText("Descripción : "  + producto.getDescripcion());
            itemProductoBinding.tvPrecio.setText(     "Precio      : "  + producto.getPrecio());

        }

    }
}