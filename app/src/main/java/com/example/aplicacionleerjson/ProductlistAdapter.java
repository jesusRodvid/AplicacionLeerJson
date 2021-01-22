package com.example.aplicacionleerjson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductlistAdapter extends RecyclerView.Adapter<ProductlistAdapter.Productview> {

    private JSONArray productlist;

    public ProductlistAdapter(JSONArray productlist) {
        this.productlist = productlist;
    }

    @NonNull
    @Override
    public Productview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list, parent, false);
       return new Productview(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Productview holder, int position) {
        try {
            holder.setData(productlist.getJSONObject(position));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return productlist.length();
    }

    public class Productview extends RecyclerView.ViewHolder{
        TextView textViewidProducto;
        TextView textViewnomProducto;
        TextView textViewPreciomin;
        TextView textViewPreciomax;
        public Productview(@NonNull View itemView) {

            super(itemView);

            textViewidProducto = itemView.findViewById(R.id.idproducto);
            textViewnomProducto = itemView.findViewById(R.id.nomproducto);
            textViewPreciomin = itemView.findViewById(R.id.preciomin);
            textViewPreciomax = itemView.findViewById(R.id.preciomax);

        }
        public void setData(JSONObject product) throws JSONException {
            textViewidProducto.setText(product.getString("id_producto"));
            textViewnomProducto.setText(product.getString("nomproducto"));
            textViewPreciomin.setText(product.getString("preciomin"));
            textViewPreciomax.setText(product.getString("preciomax"));

        }
    }
}
