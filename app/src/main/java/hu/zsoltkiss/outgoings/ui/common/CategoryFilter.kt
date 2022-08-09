package hu.zsoltkiss.outgoings.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import hu.zsoltkiss.outgoings.R
import hu.zsoltkiss.outgoings.data.model.Category


@Composable
fun CategoryFilter(
    categoriesSelected: List<Category>,
    onAdd: (Category) -> Unit = { _ -> },
    onRemove: (Category) -> Unit = { _ -> }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.paddingSize_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = Category.Clothing.toString())
            Checkbox(
                checked = categoriesSelected.contains(Category.Clothing),
                onCheckedChange = { checked ->
                    if (checked) {
                        onAdd(Category.Clothing)
                    } else {
                        onRemove(Category.Clothing)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        Row(
            modifier = Modifier.weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = categoriesSelected.contains(Category.Food),
                onCheckedChange = { checked ->
                    if (checked) {
                        onAdd(Category.Food)
                    } else {
                        onRemove(Category.Food)
                    }
                }
            )
            Text(text = Category.Food.toString())
        }

    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.paddingSize_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = Category.Housing.toString())
            Checkbox(
                checked = categoriesSelected.contains(Category.Housing),
                onCheckedChange = { checked ->
                    if (checked) {
                        onAdd(Category.Housing)
                    } else {
                        onRemove(Category.Housing)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.weight(0.2f))

        Row(
            modifier = Modifier.weight(0.4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = categoriesSelected.contains(Category.Travel),
                onCheckedChange = { checked ->
                    if (checked) {
                        onAdd(Category.Travel)
                    } else {
                        onRemove(Category.Travel)
                    }
                }
            )
            Text(text = Category.Travel.toString())
        }

    }
}