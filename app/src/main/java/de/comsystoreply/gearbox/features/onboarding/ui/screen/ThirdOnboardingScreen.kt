package de.comsystoreply.gearbox.features.onboarding.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.comsystoreply.gearbox.resource.GearboxDrawable
import de.comsystoreply.gearbox.resource.GearboxString
import de.comsystoreply.gearbox.ui.components.onboarding.OnboardingScreen

@Composable
fun ThirdOnboardingScreen(onGetStartedPressed: () -> Unit) {
    OnboardingScreen(
        title = stringResource(GearboxString.onboarding_title_3),
        description = stringResource(GearboxString.onboarding_desc_3),
        imageRes = GearboxDrawable.onboarding_picture_third,
        buttonText = stringResource(GearboxString.onboarding_get_started),
        currentPage = 3,
        onButtonClick = onGetStartedPressed
    )
}