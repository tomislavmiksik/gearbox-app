package de.comsystoreply.gearbox.common.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.ui.theme.DarkBlue
import de.comsystoreply.gearbox.ui.theme.Yellow


@Composable
fun OnboardingHeader(
    title: String,
    currentStep: Int,
    totalSteps: Int = 2
) {

    //! Refactor to be more reusable
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(text = title)
        Row {
            Icon(
                imageVector = Icons.Filled.Circle,
                modifier = Modifier.size(
                    16.dp
                ),
                contentDescription = "Circle",
                tint = if (currentStep == 1) Yellow else DarkBlue

            )
            Icon(
                imageVector = Icons.Filled.Circle,
                modifier = Modifier.size(
                    16.dp
                ),
                contentDescription = "Circle",
                tint = if (currentStep == 2) Yellow else DarkBlue

            )
        }
    }

}