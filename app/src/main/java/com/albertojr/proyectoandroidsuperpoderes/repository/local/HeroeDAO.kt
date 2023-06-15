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
    fun updateHeroeFavStateLocal(herieId: String, isFav:Boolean)


//
//    //Pictures Table
//    @Query("SELECT * FROM pictures WHERE heroe_id = :heroeID")
//    fun getPicture(heroeID: String): PictureLoccal
//
//   // @Query("INSERT into pictures VALUES :picturesList") // Fix
//    @Insert
//    fun insertAllPictures(picturesList: List<PictureLoccal>)

}
