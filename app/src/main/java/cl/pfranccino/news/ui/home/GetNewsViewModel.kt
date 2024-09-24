package cl.pfranccino.news.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.pfranccino.news.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetNewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    suspend fun getNews(){
        viewModelScope.launch {
            repository.getAllNews().fold({

            },{
             it
            })
            }
    }
}