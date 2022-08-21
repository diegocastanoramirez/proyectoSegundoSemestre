package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.service.autofill.UserData;


import co.edu.cesde.databinding.ActivityMainBinding;
import co.edu.cesde.databinding.ActivityCreateProductsBinding;

public class CreateProductsActivity extends AppCompatActivity {
    private ActivityCreateProductsBinding createProductsBinding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createProductsBinding = ActivityCreateProductsBinding.inflate(getLayoutInflater());
        View view =createProductsBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);

        //setContentView(R.layout.activity_create_products);
    }

    public  void goToFindProducs(View view){

        Intent intent =new Intent(CreateProductsActivity.this,FindProductActivity.class);

        startActivity(intent);
    }

    public  void registerProducts(View view){

        SQLiteDatabase dbr = dbHelper.getWritableDatabase();
        ContentValues userDato = new ContentValues();
        String name = createProductsBinding.etNameP.getText().toString();
        String price = createProductsBinding.etPrice.getText().toString();
        String reference = createProductsBinding.etReference.getText().toString();
        String size = createProductsBinding.etSize.getText().toString();
        userDato.put("name",name);
        userDato.put("price",price);
        userDato.put("reference",reference);
        userDato.put("size",size);
        long newProducs = dbr.insert("products",null,userDato);
        Toast.makeText(this, ""+newProducs, Toast.LENGTH_SHORT).show();




    }

}