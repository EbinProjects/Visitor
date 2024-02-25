import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp



@Composable
fun ExitedCardView(i: enterdListData) {
    Card(  modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(top = 2.dp, start = 7.dp, end = 7.dp, bottom = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier
                .defaultMinSize()
                .defaultMinSize(),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
            ) {
                Image(
                    painter = painterResource(id = i.Image as Int),
                    contentDescription = "splash",
                    modifier = Modifier.size(60.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop)
            }

            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = i.Name.toString(), modifier = Modifier
                        .padding(bottom = 3.dp)
                        .defaultMinSize(), color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = i.profesion.toString(), modifier = Modifier
                        .padding(bottom = 3.dp)
                        .defaultMinSize(), color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp), Alignment.CenterEnd) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "timer", tint = Color.Green)
                    Spacer(modifier = Modifier.padding(start = 5.dp))
                    Text(text =i.enteredTime.toString(),
                        textAlign = TextAlign.Center,
                        color = Color.Green
                    )
                }
            }

        }

    }

}