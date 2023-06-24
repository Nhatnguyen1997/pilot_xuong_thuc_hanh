package nhatph29877.fpoly.pilot_xuongth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "DS_XE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String bang_xe = "CREATE TABLE xe(id integer primary key autoincrement,tenxe text NOT NULL, hangxe text NOT NULL," +
                "namsx integer NOT NULL, giaxe double NOT NULL)";
        db.execSQL(bang_xe);

        String themxe1 = "INSERT INTO xe (tenxe, hangxe, namsx, giaxe) VALUES('bugaty-veron','bugaty','2018','400000.0')";
        db.execSQL(themxe1);
        String themxe2 = "INSERT INTO xe (tenxe, hangxe, namsx, giaxe) VALUES('luxury-A2.0turbo','vinfast','2021','5000.0')";
        db.execSQL(themxe2);
        String themxe3 = "INSERT INTO xe (tenxe, hangxe, namsx, giaxe) VALUES('bmw-350i','bmw','2022','6000')";
        db.execSQL(themxe3);
        String themxe4 = "INSERT INTO xe (tenxe, hangxe, namsx, giaxe) VALUES('porsche-911','porsche','2019','450000.0')";
        db.execSQL(themxe4);
        String themxe5 = "INSERT INTO xe (tenxe, hangxe, namsx, giaxe) VALUES('lamborghini-aventador','lamborghini','2019','550000.0')";
        db.execSQL(themxe5);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deletebang_xe = "DROP TABLE IF EXISTS xe ";
        db.execSQL(deletebang_xe);
        onCreate(db);

    }
}
