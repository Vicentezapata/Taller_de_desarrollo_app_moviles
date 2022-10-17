package roomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import roomDatabase.dao.DaoUsuario
import roomDatabase.entity.Usuario

@Database(
        entities = [Usuario::class],
        version = 1
)
abstract class Db:RoomDatabase(){
    abstract fun daoUsuario():DaoUsuario
}