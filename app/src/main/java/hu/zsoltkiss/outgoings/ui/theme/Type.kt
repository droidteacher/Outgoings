package hu.zsoltkiss.outgoings.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import hu.zsoltkiss.outgoings.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val fonts = FontFamily(
    Font(R.font.sfprotext_bold, FontWeight.Bold),
    Font(R.font.sfprotext_regular, FontWeight.Normal),
    Font(R.font.sfprotext_semibold, FontWeight.SemiBold),
    Font(R.font.sfprodisplay_medium, FontWeight.Medium)
)

val appBarTitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.Large,
            color = MaterialTheme.colors.onBackground
        )
    }


val appBarSubtitle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.Small,
            color = MaterialTheme.colors.onBackground
        )
    }

val noResults: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.Medium,
            color = MaterialTheme.colors.onBackground
        )
    }


val amountPaid: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.Medium,
            color = MaterialTheme.colors.onBackground
        )
    }


val categorySum: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.AboveLarge,
            color = MaterialTheme.colors.categorySumText
        )
    }


val transactionSummary: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.Medium,
            color = MaterialTheme.colors.onBackground
        )
    }

val transactionDate: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.BelowSmall,
            color = MaterialTheme.colors.transactionTimeText
        )
    }




@Suppress("OPT_IN_IS_NOT_ENABLED", "unused")
object TextSize {
    @OptIn(ExperimentalUnitApi::class)
    val Min = TextUnit(8f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val Micro = TextUnit(12f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val BelowSmall = TextUnit(13f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val Small = TextUnit(14f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val Medium = TextUnit(16f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val AboveMedium = TextUnit(17f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val BelowLarge = TextUnit(18f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val Large = TextUnit(20f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val AboveLarge = TextUnit(24f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val BetweenLargeAndXLarge = TextUnit(28f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val XLarge = TextUnit(34f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val XXLarge = TextUnit(45f, TextUnitType.Sp)

    @OptIn(ExperimentalUnitApi::class)
    val XXXLarge = TextUnit(56f, TextUnitType.Sp)

}