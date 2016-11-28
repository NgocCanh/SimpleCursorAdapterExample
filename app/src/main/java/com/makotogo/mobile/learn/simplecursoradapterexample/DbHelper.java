/*
 *  Copyright 2016 Makoto Consulting Group, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.makotogo.mobile.learn.simplecursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Helper class for using the DB.
 * <p>
 * I normally don't use monolithic classes like this one, but this is
 * example code, and sometimes it makes sense to keep code together like
 * this.
 * <p>
 * This class is a singleton.
 * <p>
 * <p>Enjoy the free code!</p>
 * <p>
 * Makoto Go Apps.
 * </p>
 * <p>http://makotoconsutling.com</p>
 * <p>https://github.com/makotogo</p>
 */
public class DbHelper {

    // The DB Name
    private static final String DB_NAME = "simplecursorexample.db";

    // The DB Version
    private static final int DB_VERSION = 1;

    // The instance
    private static DbHelper mInstance;

    // The Application Context
    private Context mContext;

    // The DB
    private SQLiteDatabase mSQLiteDatabase;

    // The one and only constructor
    private DbHelper(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }

        // Store the context
        mContext = context;

        // Initialize the DB
        mSQLiteDatabase = new SQLiteOpenHelper(mContext, DB_NAME, null, DB_VERSION) {

            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                // Create the Table(s)
                sqLiteDatabase.execSQL(DbSchema.PersonTable.CREATE_SQL);
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
                // Nothing to do (yet)
            }
        }.getWritableDatabase();
    }

    /**
     * Represents the DB schema
     */
    public class DbSchema {
        public class PersonTable {
            public static final String NAME = "person";
            public static final String CREATE_SQL = "CREATE TABLE " + NAME +
                    "(" +
                    Column.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    Column.LAST_NAME + " TEXT NOT NULL, " +
                    Column.FIRST_NAME + " TEXT NOT NULL, " +
                    Column.AGE + " INTEGER NOT NULL, " +
                    Column.EYE_COLOR + " TEXT NOT NULL, " +
                    Column.GENDER + " TEXT NOT NULL, " +
                    Column.WHEN_CREATED + " INTEGER NOT NULL, " +
                    "UNIQUE(" + Column.LAST_NAME + "," + Column.FIRST_NAME + "," + Column.AGE + ")" +
                    ")";

            public class Column {
                public static final String ID = "_id";// Whatever
                public static final String LAST_NAME = "last_name";
                public static final String FIRST_NAME = "first_name";
                public static final String AGE = "age";
                public static final String EYE_COLOR = "eye_color";
                public static final String GENDER = "gender";
                public static final String WHEN_CREATED = "when_created";

            }
        }
    }

    /**
     * Creates the ContentValues class necessary for using the SQlistOpenHelper
     * @param person
     * @return
     */
    private ContentValues getContentValues(Person person) {
        ContentValues ret = new ContentValues();
        ret.put(DbSchema.PersonTable.Column.ID, person.getId());
        ret.put(DbSchema.PersonTable.Column.LAST_NAME, person.getLastName());
        ret.put(DbSchema.PersonTable.Column.FIRST_NAME, person.getFirstName());
        ret.put(DbSchema.PersonTable.Column.AGE, person.getAge());
        ret.put(DbSchema.PersonTable.Column.EYE_COLOR, person.getEyeColor().toString());
        ret.put(DbSchema.PersonTable.Column.GENDER, person.getGender().toString());
        ret.put(DbSchema.PersonTable.Column.WHEN_CREATED, person.getWhenCreated().getTime());
        return ret;
    }

    //************************************
    //* P U B L I C    I N T E R F A C E *
    //************************************

    // The way to get an instance of DbHelper
    public static DbHelper instance(Context context) {
        if (mInstance == null) {
            mInstance = new DbHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    public Cursor fetchAll() {
        Cursor ret = null;
        //
        String orderBy = DbSchema.PersonTable.Column.ID;
        ret = mSQLiteDatabase.query(DbSchema.PersonTable.NAME, null, null, null, null, null, orderBy);
        //
        return ret;
    }

    public Person create(Person person) {
        Person ret = null;
        if (person.getWhenCreated() == null) {
            person.setWhenCreated(new Date());
        }
        ContentValues contentValues = getContentValues(person);
        // Insert the record
        long rowId = mSQLiteDatabase.insert(DbSchema.PersonTable.NAME, null, contentValues);
        if (rowId != -1) {
            person.setId(rowId);
            ret = person;
        }
        return ret;
    }

    public int deleteAllPeople() {
        return mSQLiteDatabase.delete(DbSchema.PersonTable.NAME, "1", null);
    }

}
