package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import co.edu.cesde.databinding.ActivityFindProductBinding;

public class FindProductActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private ActivityFindProductBinding  ProductBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProductBinding =ActivityFindProductBinding.inflate(getLayoutInflater());

        View View =ProductBinding.getRoot();
        setContentView(View);
           dbHelper = new  DbHelper(this);
    }
    public void find(View view){

        SQLiteDatabase db =dbHelper.getWritableDatabase();
        String userToFind=ProductBinding.etProducs.getText().toString();
/*
        Cursor cursor = db.rawQuery(" SELECT * FROM users WHERE identification= "  + userToFind,null );*/
        Cursor cursor = db.rawQuery(" SELECT * FROM products WHERE reference='"+ userToFind +"'  "  ,null );
        cursor.moveToNext();



        String name = cursor.getString(1);
        ProductBinding.tvProducs.setText(String.valueOf(name));

        int price = cursor.getInt(2);
        ProductBinding.tvPriceP.setText(String.valueOf(price));

        String reference = cursor.getString(3);
        ProductBinding.tvReferenceP.setText(String.valueOf(reference));

        int size = cursor.getInt(4);
        ProductBinding.tvSizeP.setText(String.valueOf(size));


    }
}