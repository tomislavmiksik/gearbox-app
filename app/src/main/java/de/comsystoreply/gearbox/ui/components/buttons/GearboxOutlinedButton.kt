package de.comsystoreply.gearbox.ui.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
fun GearboxOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    textColor: Color = colorResource(R.color.black),
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContentColor = textColor.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(28.dp),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GearboxOutlinedButtonPreview() {
    GearboxOutlinedButton(
        text = stringResource(R.string.login_google),
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxOutlinedButtonBlackPreview() {
    GearboxOutlinedButton(
        text = stringResource(R.string.login_apple),
        onClick = { },
        backgroundColor = colorResource(R.color.black),
        textColor = colorResource(R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxOutlinedButtonDisabledPreview() {
    GearboxOutlinedButton(
        text = stringResource(R.string.login_button),
        onClick = { },
        enabled = false
    )
}