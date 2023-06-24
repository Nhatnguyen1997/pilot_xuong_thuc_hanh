package nhatph29877.fpoly.pilot_xuongth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nhatph29877.fpoly.pilot_xuongth.DAO.DaoCar;
import nhatph29877.fpoly.pilot_xuongth.Model.Car;

public class ThemXe extends AppCompatActivity {
    EditText tenxe, hangxe, namsx, giaxe;
    Button luu, thoat;
    DaoCar daoCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_xe);

        tenxe = findViewById(R.id.add_tenxe);
        hangxe = findViewById(R.id.add_hangxe);
        namsx = findViewById(R.id.add_namsx);
        giaxe = findViewById(R.id.add_giaxe);
        luu = findViewById(R.id.add_luu);

        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoCar = new DaoCar(getApplicationContext());
                String them_tenxe = tenxe.getText().toString();
                String them_hangxe = hangxe.getText().toString();
                String stringnamsx = namsx.getText().toString();
                String stringgiaxe = giaxe.getText().toString();

                if (!CheckSo(stringnamsx)) {
                    namsx.requestFocus();
                    namsx.setError("Năm sản xuất phải là số");
                } else if (!CheckSo(stringgiaxe)) {
                    giaxe.requestFocus();
                    giaxe.setError("Giá xe phải là số");
                } else {
                    int them_namsx = Integer.parseInt(stringnamsx);
                    double them_giaxe = Double.parseDouble(stringgiaxe);

                    if (tenxe.length() == 0) {
                        tenxe.requestFocus();
                        tenxe.setError("Không được để trống tên xe");
                    } else if (hangxe.length() == 0) {
                        hangxe.requestFocus();
                        hangxe.setError("Không được để trống hãng xe");
                    } else if (namsx.length() == 0) {
                        namsx.requestFocus();
                        namsx.setError("Không được để trống năm sản xuất");
                    } else if (them_namsx < 1980 || them_namsx > 2023) {
                        namsx.requestFocus();
                        namsx.setError("Năm sản xuất nằm trong khoảng 1980 đến 2023");
                    } else if (them_giaxe < 0) {
                        giaxe.requestFocus();
                        giaxe.setError("Giá xe phải lớn hơn 0");
                    } else if (giaxe.length() == 0) {
                        giaxe.requestFocus();
                        giaxe.setError("Không được để trống giá xe");
                    } else {
                        daoCar = new DaoCar(getApplicationContext());
                        Car themxe = new Car(them_tenxe, them_hangxe, them_namsx, them_giaxe);
                        if (daoCar.ThemXe(themxe) > 0) {
                            Toast.makeText(ThemXe.this, "Thêm Xe Thành Công", Toast.LENGTH_SHORT).show();
                            tenxe.setText("");
                            hangxe.setText("");
                            namsx.setText("");
                            giaxe.setText("");
                            Intent intent = new Intent(ThemXe.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(ThemXe.this, "Thêm Xe Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


            }
        });

    }

    public static boolean CheckSo(String object) {
        if (object == null || object.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(object);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}