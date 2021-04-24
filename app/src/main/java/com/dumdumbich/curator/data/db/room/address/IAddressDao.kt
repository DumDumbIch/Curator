package com.dumdumbich.curator.data.db.room.address

import androidx.room.*


@Dao
interface IAddressDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(address: AddressEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg addresses: AddressEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(addresses: List<AddressEntity>)


    @Update
    fun update(address: AddressEntity)

    @Update
    fun update(vararg addresses: AddressEntity)

    @Update
    fun update(addresses: List<AddressEntity>)


    @Delete
    fun delete(address: AddressEntity)

    @Delete
    fun delete(vararg addresses: AddressEntity)

    @Delete
    fun delete(addresses: List<AddressEntity>)


    @Query("SELECT * FROM AddressEntity")
    fun getAll(): List<AddressEntity>

}