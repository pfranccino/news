package cl.pfranccino.news.saved.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cl.pfranccino.news.saved.data.local.dao.SavedNewsDao
import cl.pfranccino.news.saved.data.local.entities.SavedNewsEntity

@Database(
    entities = [SavedNewsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SavedDatabase : RoomDatabase() {

    abstract fun savedNewsDao(): SavedNewsDao

    companion object {
        const val DATABASE_NAME = "saved_news_database"
    }
}