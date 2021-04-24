package com.dumdumbich.curator.data.db.room.company

import androidx.room.*


@Dao
interface ICompanyDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(company: CompanyEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg companies: CompanyEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(companies: List<CompanyEntity>)


    @Update
    fun update(company: CompanyEntity)

    @Update
    fun update(vararg companies: CompanyEntity)

    @Update
    fun update(companies: List<CompanyEntity>)


    @Delete
    fun delete(company: CompanyEntity)

    @Delete
    fun delete(vararg companies: CompanyEntity)

    @Delete
    fun delete(companies: List<CompanyEntity>)


    @Query("SELECT * FROM CoordinateEntity")
    fun getAll(): List<CompanyEntity>

}