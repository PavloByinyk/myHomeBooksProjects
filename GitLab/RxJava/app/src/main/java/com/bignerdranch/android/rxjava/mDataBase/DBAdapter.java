//package com.bignerdranch.android.rxjava.mDataBase;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.turtledev.pockercounter.models.Charges;
//import com.turtledev.pockercounter.models.DetailCharge;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//public class DBAdapter {
//
//    Context mContext;
//    //private DBHelper dbHelper;
//    private SQLiteDatabase db;
//    private static DBAdapter dbAdapter;
//
//
//    public DBAdapter(Context AppContext) {
//        this.mContext = AppContext.getApplicationContext();
//        //dbHelper = new DBHelper(mContext);
//        db =new DBHelper(mContext).getWritableDatabase();
//
//    }
//
//    public static DBAdapter getDbAdapter(Context context){
//
//        if(dbAdapter == null) {
//            dbAdapter = new DBAdapter(context.getApplicationContext());
//        }
//        return dbAdapter;
// }
//
//
//
//
//
//
//    public void insertServerDataChargesToDB(List<Charges> list) {
//
//
//        ContentValues contenValues;
//        for (int i = 0; i < list.size(); i++) {
//            contenValues = new ContentValues();
//            if (list.get(i).getName() != null) {
//                String name = list.get(i).getName().toString();
//                String id=list.get(i).getObjectId().toString();
//                contenValues.put(DBHelper.CHARGE_ID,id);
//                contenValues.put(DBHelper.CHARGE_NAME, name);
//                db.insertWithOnConflict(DBHelper.CHARGE_TABLE_NAME, null, contenValues, SQLiteDatabase.CONFLICT_IGNORE);
//
//            }
//
//        }
//        //db.close();
//
//    }
//
//    public void insertServerDataDetailsToDB(List<DetailCharge> list) {
//
//        ContentValues contenValues;
//        for (int i = 0; i < list.size(); i++) {
//            contenValues = new ContentValues();
//
//                String parentChargeName = list.get(i).getParentChargeNAme().toString();
//                String id=list.get(i).getObjectID().toString();
//                String description=list.get(i).getDescription().toString();
//                long time=list.get(i).getTime().getTime();
//                double sum=list.get(i).getSum();
//                contenValues.put(DBHelper.DETAIL_CHARGE_ID, id);
//                contenValues.put(DBHelper.PARENT_CHARGE_NAME,parentChargeName);
//                contenValues.put(DBHelper.DESCRIPTION, description);
//                contenValues.put(DBHelper.TIME, time);
//                contenValues.put(String.valueOf(DBHelper.SUM), sum);
//                db.insertWithOnConflict(DBHelper.DETAIL_TABLE_NAME, null, contenValues, SQLiteDatabase.CONFLICT_IGNORE);
//            }
//        //db.close();
//    }
//
//
//
//
//    public boolean insertChargeToDB(String chargeName) {
//
//        ContentValues contenValues = new ContentValues();
//        contenValues.put(DBHelper.CHARGE_NAME, chargeName);
//        long result=db.insert(DBHelper.CHARGE_TABLE_NAME, null, contenValues);
//        //db.close();
//        if(result== -1)
//            return false;
//        else
//            return true;
//      }
//
//    public boolean insertDetailChargeToDB(DetailCharge detailCharge) {
//
//        ContentValues contenValues = new ContentValues();
//        contenValues.put(DBHelper.PARENT_CHARGE_NAME, detailCharge.getParentChargeNAme());
//        //contenValues.put(DBHelper.DETAIL_CHARGE_ID, detailCharge.getObjectID());
//        contenValues.put(DBHelper.DESCRIPTION, detailCharge.getDescription());
//        contenValues.put(DBHelper.SUM, detailCharge.getSum());
//        contenValues.put(DBHelper.TIME, detailCharge.getTime().getTime());
//        long result=db.insert(DBHelper.DETAIL_TABLE_NAME, null, contenValues);
//        //db.close();
//        if(result== -1)
//            return false;
//        else
//            return true;
//    }
//
//
//
//
//
//    public List<String> dBListNames() {
//        String[] columns = {DBHelper.CHARGE_NAME};
//        Cursor cursor = db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
//        ArrayList<String> listNames = new ArrayList<String>();
//        while (cursor.moveToNext()) {
//
//            int index1 = cursor.getColumnIndex(DBHelper.CHARGE_NAME);
//            String name = cursor.getString(index1);
//            listNames.add(name);
//        }
//        cursor.close();
//        //db.close();
//        return listNames;
//    }
//
//
////    public Cursor dBListCharges() {
////        String[] columns = {DBHelper.CHARGE_NAME};
////        return db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
////    }
//
//    public List<Charges> dBListCharges() {
//        String[] columns = {DBHelper.CHARGE_NAME};
//        Cursor cursor = db.query(DBHelper.CHARGE_TABLE_NAME, columns, null, null, null, null, null);
//        ArrayList<Charges> listCharges = new ArrayList<Charges>();
//        while (cursor.moveToNext()) {
//
//            int index1 = cursor.getColumnIndex(DBHelper.CHARGE_NAME);
//            String name = cursor.getString(index1);
//            Charges charges=new Charges();
//            charges.setName(name);
//            listCharges.add(charges);
//        }
//        cursor.close();
//        //db.close();
//        return listCharges;
//    }
//
//    public List<DetailCharge> dBListDetailCharges() {
//        String[] columns = {DBHelper.PARENT_CHARGE_NAME,DBHelper.DESCRIPTION,DBHelper.SUM};
//        Cursor cursor = db.query(DBHelper.DETAIL_TABLE_NAME, columns, null, null, null, null, null);
//        ArrayList<DetailCharge> listCharges = new ArrayList<DetailCharge>();
//        while (cursor.moveToNext()) {
//
//
//            int index1 = cursor.getColumnIndex(DBHelper.PARENT_CHARGE_NAME);
//            int index2 = cursor.getColumnIndex(DBHelper.DESCRIPTION);
//            int index3 = cursor.getColumnIndex(DBHelper.TIME);
//            int index4 = cursor.getColumnIndex(DBHelper.SUM);
//
//            String name = cursor.getString(index1);
//            String description = cursor.getString(index2);
//            String time = cursor.getString(index3);
//            double sum = Double.parseDouble(cursor.getString(index4));
//
//            DetailCharge charges=new DetailCharge(name,description,sum);
//
//
//            listCharges.add(charges);
//        }
//        cursor.close();
//        //db.close();
//        return listCharges;
//    }
//
//    public List<DetailCharge> getDetailList(){
//        List<DetailCharge> detailCharges=new ArrayList<DetailCharge>();
//
//        List<String> names=dBListNames();
//        for(String takeCharge : names) {
//            String[] columns = {DBHelper.SUM};
//            String selection = null;
//            String[] selectionArgs = null;
//            double sum=0;
//
//            selection = DBHelper.PARENT_CHARGE_NAME + " = ?";
//            selectionArgs = new String[]{takeCharge.toString()};
//            Cursor cursor = db.query(DBHelper.DETAIL_TABLE_NAME, columns, selection, selectionArgs, null, null,
//                    null);
//            while (cursor.moveToNext()) {
//
//                int index1 = cursor.getColumnIndex(DBHelper.SUM);
//                sum += Double.parseDouble(cursor.getString(index1));
//
//            }
//            DetailCharge detailCharge=new DetailCharge();
//            detailCharge.setSum(sum);
//            detailCharge.setParentChargeNAme(takeCharge.toString());
//            detailCharges.add(detailCharge);
//
//        }
//        return detailCharges;
//    }
//
//    public List<DetailCharge> getDetailDetailList(String name){
//        List<DetailCharge> list=new ArrayList<DetailCharge>();
//
//        String[] columns = {DBHelper.PARENT_CHARGE_NAME,DBHelper.DESCRIPTION,DBHelper.SUM,DBHelper.TIME};
//        String selection = null;
//        String[] selectionArgs = new String[]{name.toString()};
//        selection = DBHelper.PARENT_CHARGE_NAME + " = ?";
//        Cursor cursor = db.query(DBHelper.DETAIL_TABLE_NAME, columns, selection, selectionArgs, null, null,null);
//        while (cursor.moveToNext()) {
//
//            int index1 = cursor.getColumnIndex(DBHelper.PARENT_CHARGE_NAME);
//            int index2 = cursor.getColumnIndex(DBHelper.DESCRIPTION);
//            int index3 = cursor.getColumnIndex(DBHelper.SUM);
//            int index4 = cursor.getColumnIndex(DBHelper.TIME);
//
//            long time = cursor.getLong(index4);
//            String names = cursor.getString(index1);
//            String description = cursor.getString(index2);
//            double sum = cursor.getDouble(index3);
//
//            DetailCharge detailCharge=new DetailCharge();
//            detailCharge.setParentChargeNAme(names);
//            detailCharge.setTime(new Date(time));
//            detailCharge.setDescription(description);
//            detailCharge.setSum(sum);
//
//            list.add(detailCharge);
//        }
//        return list;
//    }
//
//
//}