package de.comsystoreply.gearbox.features.onboarding.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.resource.GearboxDrawable
import de.comsystoreply.gearbox.resource.GearboxString
import de.comsystoreply.gearbox.ui.components.onboarding.OnboardingScreen

@Composable
fun FirstOnboardingScreen(onNextPressed: () -> Unit) {
    OnboardingScreen(
        title = stringResource(GearboxString.onboarding_title_1),
        description = stringResource(GearboxString.onboarding_desc_1),
        imageRes = GearboxDrawable.onboarding_picture_first,
        buttonText = stringResource(GearboxString.onboarding_next),
        currentPage = 1,
        onButtonClick = onNextPressed
    )
}