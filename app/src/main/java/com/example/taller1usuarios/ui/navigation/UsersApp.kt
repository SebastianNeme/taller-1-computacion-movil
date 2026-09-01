package com.example.taller1usuarios.ui.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.taller1usuarios.data.model.User
import com.example.taller1usuarios.ui.screens.UserDetailScreen
import com.example.taller1usuarios.ui.screens.UserListScreen
import com.example.taller1usuarios.ui.viewmodel.UsersViewModel
import kotlinx.serialization.Serializable

@Serializable
private data object UserListRoute : NavKey

@Serializable
private data class UserDetailRoute(val user: User) : NavKey

@Composable
fun UsersApp(usersViewModel: UsersViewModel = viewModel()) {
    val backStack = rememberNavBackStack(UserListRoute)
    val uiState = usersViewModel.uiState.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<UserListRoute> {
                UserListScreen(
                    uiState = uiState,
                    onUserClick = { user -> backStack.add(UserDetailRoute(user)) },
                )
            }
            entry<UserDetailRoute> { route ->
                UserDetailScreen(
                    user = route.user,
                    onBack = { backStack.removeLastOrNull() },
                    onPhoneClick = { phone ->
                        val intent = Intent(Intent.ACTION_DIAL, "tel:${phone}".toUri())
                        context.startActivity(intent)
                    },
                )
            }
        },
    )
}
