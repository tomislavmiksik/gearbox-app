package de.comsystoreply.gearbox.features.onboarding.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.common.presentation.composable.OnboardingScreen


@Composable
fun FirstOnboardingScreen(onNextPressed: () -> Unit) {
    OnboardingScreen(
        title = stringResource(R.string.onboarding_title_1),
        description = stringResource(R.string.onboarding_desc_1),
        imageRes = R.drawable.onboarding_picture_first,
        buttonText = stringResource(R.string.onboarding_next),
        currentPage = 1,
        onButtonClick = onNextPressed
    )
}