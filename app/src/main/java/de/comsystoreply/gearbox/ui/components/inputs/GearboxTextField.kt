package de.comsystoreply.gearbox.ui.components.inputs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R
import de.comsystoreply.gearbox.resource.GearboxString

@Composable
fun GearboxTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    errorMessage: String? = null,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        supportingText = {
            if (errorMessage != null) {
                Text(errorMessage)
            }
        },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.dark_blue),
            unfocusedBorderColor = Color.LightGray,
            errorBorderColor = colorResource(R.color.red),
            disabledBorderColor = Color.LightGray.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(12.dp),
        isError = isError,
        enabled = enabled
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    GearboxTextField(
        value = text,
        onValueChange = { text = it },
        label = stringResource(GearboxString.login_email),
        placeholder = stringResource(GearboxString.login_email_hint),
        keyboardType = KeyboardType.Email,
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxTextFieldPasswordPreview() {
    var password by remember { mutableStateOf("") }
    GearboxTextField(
        value = password,
        onValueChange = { password = it },
        label = stringResource(GearboxString.login_password),
        placeholder = stringResource(GearboxString.login_password_hint),
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    )
}

@Preview(showBackground = true)
@Composable
fun GearboxTextFieldErrorPreview() {
    var text by remember { mutableStateOf("invalid-email") }
    GearboxTextField(
        value = text,
        onValueChange = { text = it },
        label = stringResource(GearboxString.login_email),
        placeholder = stringResource(GearboxString.login_email_hint),
        keyboardType = KeyboardType.Email,
        isError = true
    )
}