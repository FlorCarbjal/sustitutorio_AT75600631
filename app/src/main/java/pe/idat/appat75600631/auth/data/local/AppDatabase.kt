package pe.idat.appat75600631.auth.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PacienteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pacienteDao(): PacienteDao
}