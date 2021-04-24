package com.dumdumbich.curator.data.db.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dumdumbich.curator.data.db.room.aborigine.IAborigineDao
import com.dumdumbich.curator.data.db.room.address.IAddressDao
import com.dumdumbich.curator.data.db.room.company.ICompanyDao
import com.dumdumbich.curator.data.db.room.coordinate.ICoordinateDao
import com.dumdumbich.curator.data.db.room.curator.ICuratorDao
import com.dumdumbich.curator.data.db.room.mentee.IMenteeDao
import com.dumdumbich.curator.data.db.room.personal.IPersonalDao
import com.dumdumbich.curator.utils.debug.DEBUG_Database_Room
import com.dumdumbich.curator.utils.debug.IDebug
import java.lang.IllegalStateException

abstract class Database : RoomDatabase(), IDebug {

    abstract val coordinateDao: ICoordinateDao
    abstract val addressDao: IAddressDao
    abstract val company: ICompanyDao
    abstract val personal: IPersonalDao
    abstract val curator: ICuratorDao
    abstract val aborigine: IAborigineDao
    abstract val mentee: IMenteeDao


    companion object : IDebug {
        const val DATABASE_NAME = "database.db"

        private var instance: Database? = null

        fun getInstance() = instance ?: throw IllegalStateException("Database has not been created")

        fun create(context: Context) {
            debugMessage(DEBUG_Database_Room, "Database: create()")
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()
            }
        }
    }

}