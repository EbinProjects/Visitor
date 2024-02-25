
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.softland.vsitorapp.R



@Composable
fun DepartMentDetails(onNavigateToHome: NavHostController) {
    Column(modifier = Modifier.padding(top = 8.dp, start = 10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Company :",
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Softland India", color = Color.Gray, fontSize = 17.sp)
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(
            text = "Choose Department",
            color = Color(0xFFC53333),
            fontSize = 19.sp,
            fontFamily = FontFamily.Monospace
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){
            items(departmentList.alignYourDepData) { item ->
               DepartmentList(item,onNavigateToHome)
            }
        }
    }
}

    object departmentList {
        val alignYourDepData = listOf(
            enterdListData(R.drawable.n, "Production Department","football coach", "22:22:11"),
            enterdListData(R.drawable.u, "Customer Support Department", "Bank Manager","22:22:22"),
            enterdListData(R.drawable.c, "Software Department","JCB Operator", "22:22:11"),
            enterdListData(R.drawable.d, "Marketing Department", "Cutting Professional","22:22:11"),
            enterdListData(R.drawable.m, "Design Department", "Yoga Master","22:22:11"),
            enterdListData(R.drawable.n, "Safety & Security Department","football coach", "22:22:11"),
            )
}