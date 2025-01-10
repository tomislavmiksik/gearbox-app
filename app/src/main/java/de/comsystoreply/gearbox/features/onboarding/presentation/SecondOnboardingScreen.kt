package de.comsystoreply.gearbox.features.onboarding.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.common.presentation.composable.OnboardingHeader

@Composable
fun SecondOnboardingScreen(onNextPressed: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        OnboardingHeader(
            title = stringResource(R.string.onboarding_description),
            currentStep = 2
        )
        
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.onboarding_description),
                modifier = Modifier.padding(horizontal = 32.dp)
            )
        }
        
        TextButton(
            onClick = onNextPressed,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(R.string.onboarding_get_started))
        }
    }
}