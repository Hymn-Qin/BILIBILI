package projectedit.lanou.com.bilibili.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lanouhn on 16/9/27.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public   static String DATABASE_NAME="info.db";

    public static  String TRAVERL_TABLE_NAME="travel";

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlStr="create table "+TRAVERL_TABLE_NAME+" (id integer primary Key autoincrement, "
                +"money text, "+"coin text, "+"time text, "+"type text, "+"xiang text ," + "num text)";
        db.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
