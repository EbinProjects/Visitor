import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softland.vsitorapp.R
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.Screenes


@Composable
fun AddVisitor(onNavigateToHome: NavHostController) {
    var searchText by remember { mutableStateOf("") }
    val containerColor = MaterialTheme.colorScheme.onTertiary
    Column() {
    TextField(modifier = Modifier.fillMaxWidth().padding(8.dp),
        value = searchText,
        onValueChange ={searchText=it} ,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "", tint =  Color(0xFFC53333)) },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                Icon(imageVector = Icons.Default.RemoveCircle, contentDescription = "",tint =  Color(0xFFC53333),modifier = Modifier
                    .padding(end = 5.dp)
                    .offset(x = 10.dp)
                    .clickable {
                        searchText = ""
                    })
            }
        },
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Transparent,
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Black,
        ),
        placeholder = { Text(text = "Search...") }
    )
    Text(modifier = Modifier.padding(start = 10.dp),
        text = "Choose Your Company",
        color =  Color(0xFFC53333),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.padding( top = 15.dp))
    LazyVerticalGrid(
        columns = GridCells.Fixed(4) ,
        contentPadding = PaddingValues(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.defaultMinSize()
    ) {
        items(regularlist.alignYourBodyData) { item ->
            CompanyDetails(onNavigateToHome,item.Image as Int,item.Name.toString())
        }
    }
}

}


@Composable
fun CompanyDetails(onNavigateToHome: NavHostController, @DrawableRes drawable: Int, company: String) {
    Column(modifier = Modifier.clickable {
         onNavigateToHome.navigate(Screenes.departments.route)
    }, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = drawable), contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(88.dp),
            contentScale = ContentScale.Crop)
        Text(text = company,modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }

}

@Composable
fun ChooseDepartMent() {

}


object regularlist {
    val alignYourBodyData = listOf(
        enterdListData(R.drawable.n, "Valsan K.T","football coach", "22:22:11"),
        enterdListData(R.drawable.u, "Nooru", "Bank Manager","22:22:22"),
        enterdListData(R.drawable.c, "Appukkuttan","JCB Operator", "22:22:11"),
        enterdListData(R.drawable.d, "Karuppayya", "Cutting Professional","22:22:11"),
        enterdListData(R.drawable.m, "MJ Soman", "Yoga Master","22:22:11"),
        enterdListData(R.drawable.n, "Valsan K.T","football coach", "22:22:11"),
        enterdListData(R.drawable.q, "Deepu Vishwanath", "Panchayath member","22:22:11"),
        enterdListData(R.drawable.d, "Karuppayya", "Cutting Professional","22:22:11"),
        enterdListData(R.drawable.m, "MJ Soman", "Yoga Master","22:22:11"),
        enterdListData(R.drawable.c, "Appukkuttan","JCB Operator", "22:22:11"),

        )
}