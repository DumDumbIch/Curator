package com.dumdumbich.curator.data.db.room.aborigine

import androidx.room.*


@Dao
interface IAborigineDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(aborigine: AborigineEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg aborigines: AborigineEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(aborigines: List<AborigineEntity>)


    @Update
    fun update(aborigine: AborigineEntity)

    @Update
    fun update(vararg aborigines: AborigineEntity)

    @Update
    fun update(aborigines: List<AborigineEntity>)


    @Delete
    fun delete(aborigine: AborigineEntity)

    @Delete
    fun delete(vararg aborigines: AborigineEntity)

    @Delete
    fun delete(aborigines: List<AborigineEntity>)


    @Query("SELECT * FROM AborigineEntity")
    fun getAll(): List<AborigineEntity>

}