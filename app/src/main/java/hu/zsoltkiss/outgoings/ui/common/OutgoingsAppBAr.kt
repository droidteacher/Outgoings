package hu.zsoltkiss.outgoings.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import hu.zsoltkiss.outgoings.R
import hu.zsoltkiss.outgoings.ui.theme.OutgoingsTheme
import hu.zsoltkiss.outgoings.ui.theme.appBarBackground
import hu.zsoltkiss.outgoings.ui.theme.appBarSubtitle
import hu.zsoltkiss.outgoings.ui.theme.appBarTitle
import hu.zsoltkiss.outgoings.ui.theme.genericDivider

@Suppress("unused")
@Composable
fun OutgoingsAppBar(
    title: String,
    subtitle: String,
    backNavigation: @Composable (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.appBarBackground)
            ) {

                Image(painterResource(id = R.drawable.company_logo), contentDescription = "Company logo")

                Column() {
                    Text(
                        text = title,
                        style = appBarTitle,
                    )

                    Text(
                        text = subtitle,
                        style = appBarSubtitle,
                    )
                }


            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .testTag("OutgoingsAppBar"),
        backgroundColor = MaterialTheme.colors.appBarBackground,
        navigationIcon = backNavigation
    )
    Divider(
        color = MaterialTheme.colors.genericDivider,
        thickness = dimensionResource(R.dimen.divider_thickness)
    )
}


@Preview(showSystemUi = true)
@Composable
fun AppBarPreview() {
    OutgoingsTheme {
        OutgoingsAppBar(title = "Acme", subtitle = "roll with us")
    }
}