package de.comsystoreply.gearbox.ui.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.comsystoreply.gearbox.R

@Composable
fun GearboxButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = colorResource(R.color.dark_blue),
    textColor: Color = colorResource(R.color.white),
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GearboxButtonPreview() {
    GearboxButton(
        text = stringResource(R.string.login_button),
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxButtonDisabledPreview() {
    GearboxButton(
        text = stringResource(R.string.login_button),
        onClick = { },
        enabled = false
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxButtonCustomColorPreview() {
    GearboxButton(
        text = stringResource(R.string.onboarding_next),
        onClick = { },
        backgroundColor = colorResource(R.color.red),
        textColor = colorResource(R.color.white)
    )
}
