package cl.pfranccino.news.utils.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface MVI<UiState, UiAction, SideEffect> {
    val uiState: StateFlow<UiState>
    val sideEffect: Flow<SideEffect>

    fun onAction(uiAction: UiAction)

    fun updateUiState(block: UiState.() -> UiState)

    fun updateUiState(newUiState: UiState)

    // Another option would to add the extention on ViewModel
    // ViewModel.emitSideEffect(effect: SideEffect)
    // to make it easier to use if you're only using it in ViewModel
    //
    // or just leave this responsibility to the MVIDelegate to
    // get a CoroutineScope. see: https://proandroiddev.com/lighten-mvi-architecture-delegate-responsibilities-to-new-components-7ea27ea54021
    // fun emitSideEffect(effect: SideEffect)
    fun CoroutineScope.emitSideEffect(effect: SideEffect)
}

