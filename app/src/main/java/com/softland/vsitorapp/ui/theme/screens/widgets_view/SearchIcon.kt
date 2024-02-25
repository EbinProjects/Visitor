import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SearchIcon() {
    Icon(imageVector = Icons.Outlined.Search, contentDescription ="search point", tint =  Color(0xFFC53333) )
}