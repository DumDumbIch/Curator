package com.dumdumbich.curator.data.db.room.mentee

import androidx.room.*


@Dao
interface IMenteeDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(mentee: MenteeEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg mentees: MenteeEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(mentees: List<MenteeEntity>)


    @Update
    fun update(mentee: MenteeEntity)

    @Update
    fun update(vararg mentees: MenteeEntity)

    @Update
    fun update(mentees: List<MenteeEntity>)


    @Delete
    fun delete(mentee: MenteeEntity)

    @Delete
    fun delete(vararg mentees: MenteeEntity)

    @Delete
    fun delete(mentees: List<MenteeEntity>)


    @Query("SELECT * FROM MenteeEntity")
    fun getAll(): List<MenteeEntity>

}