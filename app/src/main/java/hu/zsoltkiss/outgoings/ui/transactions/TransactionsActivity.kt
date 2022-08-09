package hu.zsoltkiss.outgoings.ui.transactions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import hu.zsoltkiss.outgoings.R
import hu.zsoltkiss.outgoings.ui.common.CategoryFilter
import hu.zsoltkiss.outgoings.ui.common.OutgoingsAppBar
import hu.zsoltkiss.outgoings.ui.theme.OutgoingsTheme
import hu.zsoltkiss.outgoings.ui.theme.amountPaid
import hu.zsoltkiss.outgoings.ui.theme.categorySum
import hu.zsoltkiss.outgoings.ui.theme.genericDivider
import hu.zsoltkiss.outgoings.ui.theme.noResults
import hu.zsoltkiss.outgoings.ui.theme.transactionSummary
import hu.zsoltkiss.outgoings.ui.theme.transactionDate

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val transactionsViewModel: TransactionsViewModelImpl by viewModels()


    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OutgoingsTheme {

                Scaffold(
                    topBar = {
                        OutgoingsAppBar(
                            title = stringResource(id = R.string.header_company_name),
                            subtitle = stringResource(id = R.string.header_subtitle)
                        )
                    },
                    content = {

                        val transactions by transactionsViewModel.transactionListState
                        val processing by transactionsViewModel.processingState
                        val totalAmount by transactionsViewModel.totalAmountState
                        val filters by transactionsViewModel.currentFilterState


                        Column {

                            CategoryFilter(
                                categoriesSelected = filters,
                                onAdd = transactionsViewModel::addFilter,
                                onRemove = transactionsViewModel::removeFilter
                            )

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(dimensionResource(id = R.dimen.paddingSize_small)),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text("SUM: $totalAmount HUF", style = categorySum)
                            }

                            Box(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                if(processing) {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .padding(top = 50.dp)
                                    )
                                } else {
                                    if (transactions.isEmpty()) {
                                        Text(
                                            text = "No results",
                                            style = noResults,
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .padding(top = 50.dp)
                                        )
                                    } else {
                                        LazyColumn(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            items(transactions) { aTransaction ->
                                                Row(
                                                    modifier = Modifier.height(80.dp),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Image(
                                                        painterResource(id = aTransaction.category.imageResource!!),
                                                        contentDescription = "Category image",
                                                        modifier = Modifier.weight(0.2f)
                                                    )

                                                    Column(
                                                        modifier = Modifier.weight(0.4f)
                                                    ) {
                                                        Text(aTransaction.summary, style = transactionSummary)
                                                        Text(aTransaction.transactionDate, style = transactionDate)
                                                    }

                                                    Spacer(modifier = Modifier.weight(0.1f))

                                                    Text(
                                                        "${aTransaction.amount} ${aTransaction.currency}",
                                                        modifier = Modifier.weight(0.3f),
                                                        style = amountPaid
                                                    )
                                                }

                                                Divider(
                                                    color = MaterialTheme.colors.genericDivider,
                                                    thickness = 1.dp
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}