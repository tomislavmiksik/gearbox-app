package de.comsystoreply.gearbox.ui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.resource.GearboxString

@Composable
fun GearboxTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.black),
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun GearboxSubtitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun GearboxHeading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.black),
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun GearboxBodyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.black),
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxTitlePreview() {
    GearboxTitle(
        text = stringResource(GearboxString.login_title),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxSubtitlePreview() {
    GearboxSubtitle(
        text = stringResource(GearboxString.login_subtitle),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxHeadingPreview() {
    GearboxHeading(
        text = stringResource(GearboxString.onboarding_title_1)
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxBodyTextPreview() {
    GearboxBodyText(
        text = stringResource(GearboxString.onboarding_desc_1)
    )
}