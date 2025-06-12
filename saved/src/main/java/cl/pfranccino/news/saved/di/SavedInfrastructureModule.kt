package cl.pfranccino.news.saved.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Bind
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import cl.pfranccino.news.saved.data.local.database.SavedDatabase
import cl.pfranccino.news.saved.data.local.dao.SavedNewsDao
import cl.pfranccino.news.saved.data.repository.SavedRepositoryImpl
import cl.pfranccino.news.saved.domain.repository.SavedRepository
import cl.pfranccino.news.saved.domain.usecase.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SavedInfrastructureModule {

    @Bind
    @Singleton
    abstract fun bindSavedRepository(
        savedRepositoryImpl: SavedRepositoryImpl
    ): SavedRepository

    companion object {

        @Provides
        @Singleton
        fun provideSavedDatabase(@ApplicationContext context: Context): SavedDatabase {
            return Room.databaseBuilder(
                context,
                SavedDatabase::class.java,
                SavedDatabase.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @Singleton
        fun provideSavedNewsDao(database: SavedDatabase): SavedNewsDao {
            return database.savedNewsDao()
        }
    }
}


@Module
@InstallIn(ViewModelComponent::class)
abstract class SavedUseCaseModule {

    @Bind
    @ViewModelScoped
    abstract fun bindSaveNewsUseCase(
        saveNewsUseCaseImpl: SaveNewsUseCaseImpl
    ): SaveNewsUseCase

    @Bind
    @ViewModelScoped
    abstract fun bindSearchSavedNewsUseCase(
        searchSavedNewsUseCaseImpl: SearchSavedNewsUseCaseImpl
    ): SearchSavedNewsUseCase

    companion object {

        @Provides
        @ViewModelScoped
        fun provideGetSavedNewsUseCase(
            repository: SavedRepository
        ): GetSavedNewsUseCase {
            return GetSavedNewsUseCase {
                repository.getSavedNews()
            }
        }

        @Provides
        @ViewModelScoped
        fun provideIsNewsSavedUseCase(
            repository: SavedRepository
        ): IsNewsSavedUseCase {
            return IsNewsSavedUseCase { newsId ->
                repository.isNewsSaved(newsId)
            }
        }

        @Provides
        @ViewModelScoped
        fun provideRemoveSavedNewsUseCase(
            repository: SavedRepository
        ): RemoveSavedNewsUseCase {
            return RemoveSavedNewsUseCase { newsId ->
                repository.removeSavedNews(newsId)
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetSavedNewsBySourceUseCase(
            repository: SavedRepository
        ): GetSavedNewsBySourceUseCase {
            return GetSavedNewsBySourceUseCase { sourceName ->
                repository.getSavedNewsBySource(sourceName)
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetSavedNewsByAuthorUseCase(
            repository: SavedRepository
        ): GetSavedNewsByAuthorUseCase {
            return GetSavedNewsByAuthorUseCase { authorName ->
                repository.getSavedNewsByAuthor(authorName)
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetAllAuthorsUseCase(
            repository: SavedRepository
        ): GetAllAuthorsUseCase {
            return GetAllAuthorsUseCase {
                repository.getAllAuthors()
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetAllSourcesUseCase(
            repository: SavedRepository
        ): GetAllSourcesUseCase {
            return GetAllSourcesUseCase {
                repository.getAllSources()
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetSavedNewsCountUseCase(
            repository: SavedRepository
        ): GetSavedNewsCountUseCase {
            return GetSavedNewsCountUseCase {
                repository.getSavedNewsCount()
            }
        }

        @Provides
        @ViewModelScoped
        fun provideGetSavedNewsByIdUseCase(
            repository: SavedRepository
        ): GetSavedNewsByIdUseCase {
            return GetSavedNewsByIdUseCase { newsId ->
                repository.getSavedNewsById(newsId)
            }
        }

        @Provides
        @ViewModelScoped
        fun provideIsNewsUrlSavedUseCase(
            repository: SavedRepository
        ): IsNewsUrlSavedUseCase {
            return IsNewsUrlSavedUseCase { url ->
                repository.isNewsUrlSaved(url)
            }
        }
    }
}