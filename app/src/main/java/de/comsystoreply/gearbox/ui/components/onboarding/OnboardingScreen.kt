package de.comsystoreply.gearbox.ui.components.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.ui.components.buttons.GearboxButton
import de.comsystoreply.gearbox.ui.components.indicators.GearboxPageIndicator
import de.comsystoreply.gearbox.ui.components.text.GearboxHeading
import de.comsystoreply.gearbox.ui.components.text.GearboxSubtitle

@Composable
fun OnboardingScreen(
    title: String,
    description: String,
    @DrawableRes imageRes: Int,
    buttonText: String,
    currentPage: Int,
    totalPages: Int = 3,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(Color.White),
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .weight(2f),
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.5f)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                colorResource(R.color.white),
                            ),
                        )
                    )
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                GearboxHeading(
                    text = title,
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    GearboxPageIndicator(
                        currentPage,
                        totalPages,
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            GearboxSubtitle(
                text = description,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(4f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, end = 8.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            GearboxButton(
                text = buttonText,
                onClick = onButtonClick,
                backgroundColor = colorResource(R.color.dark_blue),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(
        buttonText = stringResource(R.string.onboarding_next),
        title = stringResource(R.string.onboarding_title_1),
        description = stringResource(R.string.onboarding_desc_1),
        imageRes = R.drawable.onboarding_picture_first, // Using built-in drawable for preview
        currentPage = 1,
        totalPages = 3,
    ) { }
}