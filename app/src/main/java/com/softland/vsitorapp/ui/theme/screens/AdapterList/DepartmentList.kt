import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.Screenes


@Composable
fun DepartmentList(item: enterdListData, onNavigateToHome: NavHostController) {
    val context = LocalContext.current
    Card(  modifier = Modifier
        .fillMaxWidth()
        .height(75.dp)
        .padding(top = 5.dp, bottom = 4.dp).clickable {
            onNavigateToHome.navigate(Screenes.details.route)
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp
        )) {
        Row(
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.Image as Int),
                contentDescription = "splash",
                modifier = Modifier
                    .size(35.dp),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(
                text = item.Name.toString(), modifier = Modifier.padding(bottom = 3.dp).defaultMinSize(), color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
