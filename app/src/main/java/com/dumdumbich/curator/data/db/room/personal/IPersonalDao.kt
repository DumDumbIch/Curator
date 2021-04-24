package com.dumdumbich.curator.data.db.room.personal

import androidx.room.*


@Dao
interface IPersonalDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(personal: PersonalEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg personals: PersonalEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(personals: List<PersonalEntity>)


    @Update
    fun update(personal: PersonalEntity)

    @Update
    fun update(vararg personals: PersonalEntity)

    @Update
    fun update(personals: List<PersonalEntity>)


    @Delete
    fun delete(personal: PersonalEntity)

    @Delete
    fun delete(vararg personals: PersonalEntity)

    @Delete
    fun delete(personals: List<PersonalEntity>)


    @Query("SELECT * FROM PersonalEntity")
    fun getAll():List<PersonalEntity>

}