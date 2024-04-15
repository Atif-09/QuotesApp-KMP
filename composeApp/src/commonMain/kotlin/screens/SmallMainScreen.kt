package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import api.ApiClass
import kotlinx.coroutines.launch
import model.QuotesDataClassItem

@Composable
fun SmallMainScreenUI() {
Column(modifier = Modifier.fillMaxSize()){
    var quotesList by remember { mutableStateOf<List<QuotesDataClassItem?>>(emptyList()) }
    val scope = rememberCoroutineScope()
    scope.launch {
        quotesList = ApiClass().githubUsers()
    }
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(quotesList){quote->
            SmallQuoteCard(quote!!.q, quote.a)

        }
    }
}
}

@Composable
fun SmallQuoteCard(
    quote: String,
    author: String
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(200.dp)
            .background(color = Color(0xFF6D75E7), shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quote,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = author,
                textAlign = TextAlign.Center
            )
        }
    }
}

