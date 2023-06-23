package com.albertojr.proyectoandroidsuperpoderes.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.albertojr.proyectoandroidsuperpoderes.repository.local.models.HeroeLocal

@Dao
interface HeroeDAO {

    @Query("SELECT * FROM heroes")
    fun getHeroes(): List<HeroeLocal>

    @Query("SELECT * FROM heroes WHERE id = :heroeID")
    fun getHeroe(heroeID: Long): HeroeLocal

    @Insert
    fun insertAllHeroes(heroesList: List<HeroeLocal>)

    @Query("UPDATE heroes SET isFavourite=:isFav WHERE id=:herieId")
    fun updateHeroeFavStateLocal(herieId: Long, isFav:Boolean)

}
