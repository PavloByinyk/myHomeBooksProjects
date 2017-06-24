package ua.com.pbyinyk.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ua.com.pbyinyk.criminalintent.database.CrimeBaseHelper;
import ua.com.pbyinyk.criminalintent.database.CrimeCursorWrapper;

import static ua.com.pbyinyk.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by 1 on 29.04.2016.
 */
public class CrimeLab {

    private Context mAppContext;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private static CrimeLab sCrimeLab;

    // Закритий конструктор CrimeLab
    private CrimeLab(Context AppContext) {
        this.mContext = AppContext.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
    }

    //Метод гет для виклику або першого і  єдиного створення сінглтонного обєкта CrimeLab
    public static CrimeLab get(Context context) {
        if(sCrimeLab==null){
            sCrimeLab=new CrimeLab(context.getApplicationContext());

        }
        return sCrimeLab;
    }

    private static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID, crime.getmId().toString());
        values.put(CrimeTable.Cols.TITLE, crime.getmTitle());
        values.put(CrimeTable.Cols.DATE, crime.getmDate().getTime());
        values.put(CrimeTable.Cols.SOLVED, crime.ismSolved() ? 1 : 0);
        values.put(CrimeTable.Cols.SUSPECT, crime.getmSuspect());
        return values;
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getmId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update(CrimeTable.NAME, values,
                CrimeTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }
    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CrimeTable.NAME,
                null, // Columns - null выбирает все столбцы
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new CrimeCursorWrapper(cursor);
    }
    public void addCrime(Crime c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeTable.NAME, null, values);
    }



    public Crime getCrime(UUID id){
        CrimeCursorWrapper cursor = queryCrimes(
                CrimeTable.Cols.UUID + " = ?",
               new String[] { id.toString() }
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }


    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        CrimeCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return crimes;
    }

    public File getPhotoFile(Crime crime) {
        File externalFilesDir = mContext
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        return new File(externalFilesDir, crime.getPhotoFilename());
    }
}
