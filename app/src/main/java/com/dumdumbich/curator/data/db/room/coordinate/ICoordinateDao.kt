package com.dumdumbich.curator.data.db.room.coordinate

import androidx.room.*


@Dao
interface ICoordinateDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(coordinate: CoordinateEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg coordinates: CoordinateEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(coordinates: List<CoordinateEntity>)


    @Update
    fun update(coordinate: CoordinateEntity)

    @Update
    fun update(vararg coordinates: CoordinateEntity)

    @Update
    fun update(coordinates: List<CoordinateEntity>)


    @Delete
    fun delete(coordinate: CoordinateEntity)

    @Delete
    fun delete(vararg coordinates: CoordinateEntity)

    @Delete
    fun delete(coordinates: List<CoordinateEntity>)


    @Query("SELECT * FROM CoordinateEntity")
    fun getAll(): List<CoordinateEntity>

}