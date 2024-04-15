import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import api.ApiClass
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.LargeMainScreenUI

@Composable
@Preview
fun App() {
    MaterialTheme {

        if (getPlatform().name.contains("Desktop")){
            LargeMainScreenUI()
        }

        /*val scope = rememberCoroutineScope()
        scope.launch {
            val data = ApiClass().githubUsers()
            println("Size of quotes data ${data.size}")
                for (i in data){
                    println("Quote: ${i.q} + ${i.a}")
                }

        }*/
    }
}