package de.comsystoreply.gearbox.ui.components.indicators

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.comsystoreply.gearbox.R

@Composable
fun GearboxPageIndicator(
    currentPage: Int,
    totalPages: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = colorResource(R.color.yellow),
    inactiveColor: Color = colorResource(R.color.dark_blue)
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(
                        if (index + 1 == currentPage) activeColor else inactiveColor,
                        CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageIndicatorPreview() {
    GearboxPageIndicator(
        currentPage = 2,
        totalPages = 3
    )
}

@Preview(showBackground = true)
@Composable
fun PageIndicatorFirstPagePreview() {
    GearboxPageIndicator(
        currentPage = 1,
        totalPages = 3
    )
}

@Preview(showBackground = true)
@Composable
fun PageIndicatorLastPagePreview() {
    GearboxPageIndicator(
        currentPage = 3,
        totalPages = 3
    )
}