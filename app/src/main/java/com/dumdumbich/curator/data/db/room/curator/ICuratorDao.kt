package com.dumdumbich.curator.data.db.room.curator

import androidx.room.*


@Dao
interface ICuratorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(curator: CuratorEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg curators: CuratorEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(curators: List<CuratorEntity>)


    @Update
    fun update(curator: CuratorEntity)

    @Update
    fun update(vararg curators: CuratorEntity)

    @Update
    fun update(curators: List<CuratorEntity>)


    @Delete
    fun delete(curator: CuratorEntity)

    @Delete
    fun delete(vararg curators: CuratorEntity)

    @Delete
    fun delete(curators: List<CuratorEntity>)


    @Query("SELECT * FROM CuratorEntity")
    fun getAll(): List<CuratorEntity>

}