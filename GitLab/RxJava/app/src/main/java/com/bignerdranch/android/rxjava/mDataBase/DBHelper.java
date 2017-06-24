package com.bignerdranch.android.rxjava.mDataBase;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 1 on 28.05.2016.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final String TAG ="myTag" ;
    private Context context;

    //DB
     static final String DATABASE_NAME = "DBCharges";
     private static int DB_VERSION = 2;

    //TableCharges table
     public static final String CHARGE_TABLE_NAME = "TableCharges";

    public static final String CHARGE_ID ="_id";
     public static final String CHARGE_NAME = "Name";






    //CreateTable
     static final String CREATE_CHARGE_TABLE = "CREATE TABLE "+ CHARGE_TABLE_NAME
            + " ( " + CHARGE_NAME +" STRING  ,"
            + CHARGE_ID +  " STRING PRIMARY KEY);";





    //Drop Table
     static final String DROP_CHARGES_TABLE = "DROP TABLE IF EXISTS " + CHARGE_TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_CHARGE_TABLE);

            Toast.makeText(context," CREATE DB",Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context,"ERROR CREATE DB"+e,Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context," UPDATE DB",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_CHARGES_TABLE);

            onCreate(db);

        } catch (SQLException e) {
            Toast.makeText(context,"ERROR UPDATE DB"+e,Toast.LENGTH_SHORT).show();
        }

    }


//    private static <T> Observable<T> makeObservable(final Callable<T> func) {
//        return Observable.create(
//                new Observable.OnSubscribe<T>() {
//                    @Override
//                    public void call(Subscriber<? super T> subscriber) {
//                        try {
//                            subscriber.onNext(func.call());
//                        } catch(Exception ex) {
//                            Log.e(TAG, "Error reading from the database", ex);
//                        }
//                    }
//                });
//    }
//
//
//    public Observable<List<Charge>> getUsers(SQLiteDatabase db) {
//        return makeObservable(getUser(db))
//                .subscribeOn(Schedulers.computation());
//    }
//
//
//    public Callable<List<Charge>> getUser(SQLiteDatabase db) {
//        return new Callable()  {
//            @Override
//            public List<Charge> call() {
//                // select * from users where _id is userId
//                return dBListCharges(db);
//            }
//        };
//    }

//    public class MyDBHelper {
//
//        Context mContext;
//        //private DBHelper dbHelper;
//        private SQLiteDatabase db;
//        private static MyDBHelper dbAdapter;
//
//
//        public DBAdapter(Context AppContext) {
//            this.mContext = AppContext.getApplicationContext();
//            //dbHelper = new DBHelper(mContext);
//            db =new DBHelper(mContext).getWritableDatabase();
//
//        }
//
//        public static DBAdapter getDbAdapter(Context context){
//
//            if(dbAdapter == null) {
//                dbAdapter = new DBAdapter(context.getApplicationContext());
//            }
//            return dbAdapter;
//        }
//
//
//        Callable<List<Charge>> getUsers(SQLiteDatabase db) {
//            return new Callable<List<Charge>>() {
//                @Override
//                public List<Charge> call() {
//                    // select * from users where _id is userId
//                    return dBListCharges(db);
//                }
//            };
//        }
//
//        public Observable<List<Charge>> getUsers1() {
//            Log.e(TAG, "в getUsers1" + Thread.currentThread().getName().toString());
//            return makeObservable(getUsers(getReadableDatabase()))
//                    .subscribeOn(Schedulers.io()); // note: do not use Schedulers.io()
//
//        }
//
//        private static <T> Observable<T> makeObservable(final Callable<T> func) {
//            return Observable.create(
//                    new Observable.OnSubscribe<T>() {
//                        @Override
//                        public void call(Subscriber<? super T> subscriber) {
//                            try {
//                                subscriber.onNext(func.call());
//                            } catch (Exception ex) {
//                                Log.e(TAG, "Error reading from the database", ex);
//                            }
//                        }
//                    });
//        }
//
//
//        public List<Charge> dBListCharges(SQLiteDatabase db) {
//            String[] columns = {DBHelper.CHARGE_NAME, DBHelper.CHARGE_ID};
//            Cursor cursor = db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
//            ArrayList<Charge> listCharges = new ArrayList<Charge>();
//            while (cursor.moveToNext()) {
//
//                int index1 = cursor.getColumnIndex(DBHelper.CHARGE_NAME);
//                int index2 = cursor.getColumnIndex(DBHelper.CHARGE_ID);
//                String id = cursor.getString(index2);
//                String name = cursor.getString(index1);
//                Charge charges = new Charge();
//                charges.setName(name);
//                charges.setId(id);
//                listCharges.add(charges);
//            }
//            cursor.close();
//            //db.close();
//            return listCharges;
//        }
//
//        public void insertServerDataChargesToDB(List<Charge> list, SQLiteDatabase db) {
//
//
//            ContentValues contenValues;
//            for (int i = 0; i < list.size(); i++) {
//                contenValues = new ContentValues();
//                if (list.get(i).getName() != null) {
//                    String name = list.get(i).getName().toString();
//                    String id = list.get(i).getId().toString();
//                    contenValues.put(DBHelper.CHARGE_ID, id);
//                    contenValues.put(DBHelper.CHARGE_NAME, name);
//                    db.insertWithOnConflict(DBHelper.CHARGE_TABLE_NAME, null, contenValues, SQLiteDatabase.CONFLICT_IGNORE);
//
//                }
//
//            }
//            //db.close();
//
//        }
//
//        public void loadTodb(Context context, List<Charge> list) {
//
//            Observable.just(list)
//                    .subscribeOn(Schedulers.newThread())
//                    .subscribe(new Action1<List<Charge>>() {
//
//                        @Override
//                        public void call(List<Charge> charges) {
//
//                            new DBHelper(context).insertServerDataChargesToDB(charges, sqLiteDatabase);
//                            //Thread.currentThread().getName().toString();
//                            Log.e(TAG, "Дані загружені в бд" + Thread.currentThread().getName().toString());
//                        }
//                    });
//
//
//        }
//
//    }
}
