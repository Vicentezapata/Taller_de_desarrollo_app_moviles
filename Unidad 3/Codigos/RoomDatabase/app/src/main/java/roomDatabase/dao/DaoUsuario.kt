package roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDatabase.entity.Usuario

@Dao
interface DaoUsuario {
    @Query("SELECT * FROM Usuario")
    //METODO APRA OBTENER LA INFO
    //suspend son las corrutinas estas son una de las características más impresionantes de Kotlin is simply a function that can be paused and resumed
    suspend fun obtenerUsuario(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE usuario=:usuario")
    suspend fun obtenerUsuario(usuario: String): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE usuario=:usuario AND contrasena=:contrasena")
    suspend fun login(usuario: String, contrasena: String): List<Usuario>

    @Insert
    suspend fun agregarUsuario(usuario: Usuario):Long

    //=: nos permite parametrizar
    @Query("UPDATE  Usuario SET nombre=:nombre,contrasena=:contrasena WHERE usuario=:usuario")
    suspend fun actualziarUsuario(nombre:String,usuario: String,contrasena:String): Int

    @Query("DELETE FROM Usuario WHERE usuario=:usuario")
    suspend fun borrarUsuario(usuario: String)
}