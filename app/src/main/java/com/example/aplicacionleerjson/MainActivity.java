package com.example.aplicacionleerjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class MainActivity extends AppCompatActivity {
    String jsonString="{\"Productos\":[{\"id_producto\":\"1\",\"nomproducto\":\"papa chinegua\",\"preciomin\":\"0.9\",\"preciomax\":\"1.2\"},{\"id_producto\":\"2\"," +
            "\"nomproducto\":\"aguacate\",\"preciomin\":\"5\",\"preciomax\":\"6\"},{\"id_producto\":\"0\",\"nomproducto\":\"zanahorias\",\"preciomin\":\"0.7\",\"preciomax\":\"1.2\"},{\"id_producto\":\"3\",\"nomproducto\":\"Rabanos\"," +
            "\"preciomin\":\"1.3\",\"preciomax\":\"1.6\"},{\"id_producto\":\"4\",\"nomproducto\":\"Mango\",\"preciomin\":\"3.3\",\"preciomax\":\"4.15\"},{\"id_producto\":\"5\",\"nomproducto\":\"Tomate\",\"preciomin\":\"0.7\",\"preciomax\":\"1.4\"}]}";

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.reciclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray jproducts = obj.getJSONArray("Productos");
            recyclerView.setAdapter(new ProductlistAdapter(jproducts));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}