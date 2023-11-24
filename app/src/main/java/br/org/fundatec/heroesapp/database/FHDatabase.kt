package br.org.fundatec.heroesapp.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.org.fundatec.heroesapp.App
import br.org.fundatec.heroesapp.database.converter.Converters
import br.org.fundatec.heroesapp.login.data.local.UserDao
import br.org.fundatec.heroesapp.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}