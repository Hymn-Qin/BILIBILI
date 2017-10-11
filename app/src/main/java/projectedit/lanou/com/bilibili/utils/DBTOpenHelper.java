package projectedit.lanou.com.bilibili.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lanouhn on 16/10/13.
 */
public class DBTOpenHelper extends SQLiteOpenHelper {
    public   static String TRANS_NAME="tran.db";

    public static  String TRAVERL_TABLE_NAME="trans";

    public DBTOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlStr="create table "+TRAVERL_TABLE_NAME+" (id integer primary Key autoincrement, "
                +"before text, "+"after text) ";
        db.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
