package nhatph29877.fpoly.pilot_xuongth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import nhatph29877.fpoly.pilot_xuongth.Adapter.AdapterXe;
import nhatph29877.fpoly.pilot_xuongth.DAO.DaoCar;
import nhatph29877.fpoly.pilot_xuongth.Model.Car;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addxe;
    AdapterXe adapterXe;
    DaoCar daoCar;
    ArrayList<Car> listcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_car);
        addxe = findViewById(R.id.addcar);
        reloaddata();
        addxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemXe.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        reloaddata();
    }

    public void reloaddata() {
        daoCar = new DaoCar(getApplicationContext());
        listcar = daoCar.GetDSSCar();
        adapterXe = new AdapterXe(MainActivity.this, listcar, daoCar);
        recyclerView.setAdapter(adapterXe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}