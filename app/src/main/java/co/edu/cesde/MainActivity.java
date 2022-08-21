package co.edu.cesde;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.cesde.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // private EditText etEmail,etPassword;
    // Button btnSignIn,btnSignUp;
    //private TextView tvForgotPasword;
    private ActivityMainBinding mainBinding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        dbHelper=new DbHelper(this);


        //setContentView(R.layout.activity_main);
        //etEmail=findViewById(R.id.etEmail);
        //etPassword=findViewById(R.id.etPassword);
        //btnSignIn=findViewById(R.id.btnSignIn);
        //btnSignUp=findViewById(R.id.btnSignUp);
       // tvForgotPasword=findViewById(R.id.tvForgotPasword);
        mainBinding.btnSignIn.setOnClickListener(this);
        mainBinding.btnSignUp.setOnClickListener(this);


    }



    public  void goToProducs()  {
        Intent intent =new Intent(MainActivity.this,CreateProductsActivity.class);

        startActivity(intent);

    }


    public  void goToRegister(){

        Intent intent =new Intent(MainActivity.this,RegisterActivity.class);

        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignIn:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String userEmail = mainBinding.etEmailR.getText().toString();
                String passwordUser = mainBinding.etPassword.getText().toString();
                Cursor cursor = db.rawQuery(" SELECT * FROM users WHERE email =   '"  + userEmail+ "'",null );
                cursor.moveToNext();
                Cursor cursor2 = db.rawQuery(" SELECT * FROM users WHERE password =   '"+ passwordUser +"'  " ,null );
                cursor2.moveToNext();
                String email = cursor.getString(2);
                String passwordd = cursor.getString(4);


                if(passwordUser.equals(passwordd)&&userEmail.equals(email)){

                    goToProducs();
                }
            break;
            case R.id.btnSignUp:
                goToRegister();
                break;

        }



    }
}