package nhatph29877.fpoly.pilot_xuongth.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import nhatph29877.fpoly.pilot_xuongth.DBHelper;
import nhatph29877.fpoly.pilot_xuongth.Model.Car;


public class DaoCar {
    private DBHelper dbHelper;

    public DaoCar(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<Car> GetDSSCar() {
        ArrayList<Car> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM xe", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Car car = new Car();
                car.setId(Integer.parseInt(cursor.getString(0)));
                car.setTenxe(cursor.getString(1));
                car.setHangxe(cursor.getString(2));
                car.setNamsx(Integer.parseInt(cursor.getString(3)));
                car.setGiaxe(Double.parseDouble(cursor.getString(4)));
                list.add(car);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public long ThemXe(Car car) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenxe", car.getTenxe());
        contentValues.put("hangxe", car.getHangxe());
        contentValues.put("namsx", car.getNamsx());
        contentValues.put("giaxe", car.getGiaxe());

        return sqLiteDatabase.insert("xe", null, contentValues);
    }

    public long XoaXe(int id) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        return sqLiteDatabase.delete("xe", "id = ? ", new String[]{String.valueOf(id)});
    }
}
