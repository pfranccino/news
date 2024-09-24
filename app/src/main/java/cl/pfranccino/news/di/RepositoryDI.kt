package cl.pfranccino.news.di

import cl.pfranccino.news.data.repository.NewsRepositoryImpl
import cl.pfranccino.news.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryDI {
    @Binds
    abstract fun bindNewsRepository(impl: NewsRepositoryImpl) : NewsRepository
}