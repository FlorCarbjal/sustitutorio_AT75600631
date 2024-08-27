package pe.idat.appat75600631.auth.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns

@Dao
@RewriteQueriesToDropUnusedColumns
interface PacienteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaciente(paciente: PacienteEntity)

    @Query("SELECT * FROM pacientes WHERE codpaciente = :codpaciente AND password = :password LIMIT 1")
    suspend fun getPaciente(codpaciente: String, password: String): PacienteEntity?
}