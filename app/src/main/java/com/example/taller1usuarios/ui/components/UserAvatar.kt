package com.example.taller1usuarios.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent

@Composable
fun UserAvatar(
    imageUrl: String,
    fullName: String,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "Foto de $fullName",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        loading = { AvatarPlaceholder() },
        error = { AvatarPlaceholder() },
        success = { SubcomposeAsyncImageContent() },
    )
}

@Composable
private fun AvatarPlaceholder() {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(32.dp),
        )
    }
}
