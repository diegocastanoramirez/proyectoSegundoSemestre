package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityMainBinding;
import co.edu.cesde.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding registerBinding;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = registerBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);


        //setContentView(R.layout.activity_register);
    }


    public  void goToMain(){

        Intent intent =new Intent(RegisterActivity.this,MainActivity.class);

        startActivity(intent);
    }

    public  void registerUser(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String name = registerBinding.etName.getText().toString();
        String document = registerBinding.etDocument.getText().toString();
        String email = registerBinding.etEmailR.getText().toString();
        String password = registerBinding.etPasswordR.getText().toString();
       userData.put("name",name);
       userData.put("email",email);
       userData.put("identification",document);
       userData.put("password",password);
       long newUser = db.insert("users",null,userData);
        Toast.makeText(this, ""+newUser, Toast.LENGTH_SHORT).show();
        goToMain();







    }
}