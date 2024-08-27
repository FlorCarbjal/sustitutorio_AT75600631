package pe.idat.appat75600631.core.retrofit

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.idat.appat75600631.auth.data.local.AppDatabase
import pe.idat.appat75600631.auth.data.local.PacienteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "paciente_database"
        ).build()
    }

    @Provides
    fun providePacienteDao(db: AppDatabase): PacienteDao {
        return db.pacienteDao()
    }
}
