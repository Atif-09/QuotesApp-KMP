package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.ApiClass
import kotlinx.coroutines.launch
import model.QuotesDataClassItem

@Composable
fun LargeMainScreenUI() {
    var quotesList by remember { mutableStateOf<List<QuotesDataClassItem?>>(emptyList()) }
    val scope = rememberCoroutineScope()
    scope.launch {
        quotesList = ApiClass().githubUsers()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(9.dp),
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            modifier = Modifier.fillMaxWidth(0.9f).align(Alignment.CenterHorizontally)
                .padding(12.dp)
        ) {
            items(quotesList) { quote ->

                QuoteCard(quote!!.q, quote.a)
                /*ElevatedCard(
                    modifier = Modifier.height(300.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(9.dp)),
                    shape = RoundedCornerShape(9.dp), elevation = CardDefaults.cardElevation(
                        defaultElevation = 9.dp
                    )
                ) {
                    Column(modifier = Modifier.fillMaxWidth().padding(18.dp)) {
                        Text(quote!!.q, modifier = Modifier.align(Alignment.CenterHorizontally))
                        Text(quote.a, modifier = Modifier.align(Alignment.CenterHorizontally))

                    }
                }*/

            }
        }

    }
}

@Composable
fun QuoteCard(quote: String, author: String) {
    Card(
        modifier = Modifier
            .width(180.dp) // Adjust width as needed
            .height(150.dp) // Adjust height as needed
            .padding(8.dp),
        border = BorderStroke(1.5.dp, Color(0xFFe7e7e7)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = quote,
                fontSize = 16.sp,
                color = Color(0xFF999999),
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            Text(
                text = author,
                fontSize = 12.sp,
                color = Color(0xFF605b5a),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )


        }
    }
}