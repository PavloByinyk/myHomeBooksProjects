package ua.com.pbyinyk.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import ua.com.pbyinyk.criminalintent.Crime;

import static ua.com.pbyinyk.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by 1 on 09.06.2016.
 */
public class CrimeCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setmTitle(title);
        crime.setmDate(new Date(date));
        crime.setmSolved(isSolved != 0);
        crime.setmSuspect(suspect);
        return crime;
    }
}
