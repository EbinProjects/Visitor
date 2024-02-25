import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.softland.vsitorapp.R
import com.softland.vsitorapp.ui.theme.Utilss.FileUtils
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsEntry(onNavigateToHome: NavHostController) {
    val containerColor = Color( Color(0xFFE3E8F1).toArgb())
    var selectedUri by remember { mutableStateOf(mutableStateListOf<Uri>()) }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // Handle the selected file URI here
        uri?.let { selectedUri.add(it) }
    }
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 10.dp , end = 10.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally){
        val suggestionsVisitor = listOf("Operator","Operator 1","Operator 4", "Manager", "Attender","Attender 2", "Main Operator 1","Main Operator","Accountant 1", "Accountant","Sleeper","Worker","Safety Officer")
        val purposeVisit = listOf(
            "Business",
            "Tourism",
            "Education",
            "Medical",
            "Other",
            "Family Visit",
            "Conference",
            "Research",
            "Training",
            "Religious",)
        var expandedVisitor by remember { mutableStateOf(false) }
        var selectedTextVisitor by remember { mutableStateOf("") }
        var textfieldSize by remember { mutableStateOf(Size.Zero)}
        val icon = if (expandedVisitor)
            Icons.Filled.ArrowDropUp
        else
            Icons.Filled.ArrowDropDown
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp , end = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Company :",
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Soft-land India", color = Color.Gray, fontSize = 17.sp)
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp , end = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Department :",
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Software Department", color = Color.Gray, fontSize = 17.sp)
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Box() {
           TextField(
                value = selectedTextVisitor,
                onValueChange = { selectedTextVisitor = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
               placeholder = {
                   Text("Choose whom to visit")
               },
               singleLine = true,
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable { expandedVisitor = !expandedVisitor })
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
            )
            DropdownMenu(
                expanded = expandedVisitor,
                onDismissRequest = { expandedVisitor = false },
                modifier = Modifier
//                    .width(with(LocalDensity.current){textfieldSize.width.toDp()})
            ) {
                suggestionsVisitor.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label) },
                        onClick = {
                            selectedTextVisitor = label
                    })
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        var visiterNametext by remember { mutableStateOf("") }
        TextField(
            value = visiterNametext,
            onValueChange = { visiterNametext = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                }
                .background(Color(0xFFC53333)),
            singleLine = true,
            placeholder = {
                Text("Enter visitor’s name")
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
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        var visiterPhonetext by remember { mutableStateOf("") }
        TextField(
            value = visiterPhonetext,
            onValueChange = { visiterPhonetext = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            singleLine = true,
            placeholder = {
                Text("Enter mobile number")
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
        )
        Spacer(modifier = Modifier.padding(top = 5.dp))
        var ChoosePurposetxt by remember { mutableStateOf("") }
        var expandedPurpose by remember { mutableStateOf(false) }
        val iconPurpose = if (expandedVisitor)
            Icons.Filled.ArrowDropUp
        else
            Icons.Filled.ArrowDropDown
        Box() {
            TextField(
                value = ChoosePurposetxt,
                onValueChange = { ChoosePurposetxt = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textfieldSize = coordinates.size.toSize()
                    },
                placeholder = {
                    Text("Choose the purpose")
                },
                singleLine = true,
                trailingIcon = {
                    Icon(iconPurpose,"contentDescription",
                        Modifier.clickable { expandedPurpose = !expandedPurpose })
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
            )
            DropdownMenu(
                expanded = expandedPurpose,
                onDismissRequest = { expandedPurpose = false },
                modifier = Modifier
            ) {
                purposeVisit.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label) },
                        onClick = {
                            ChoosePurposetxt = label
                        })
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        DataUploading(onNavigateToHome,launcher,selectedUri)
        Spacer(modifier = Modifier.padding(top = 5.dp))
        val checkedState = remember { mutableStateOf(true) }
        Row(verticalAlignment = Alignment.CenterVertically){
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },)
            Text(text = "Collected original documents from visitor",
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 6.dp),
                color = Color.Black)
        }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Button(modifier = Modifier.width(335.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC53333))) {
            Text("Submit")
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }

    }

@Composable
fun DataUploading(
    navigation: NavHostController ,
    launcher1: ManagedActivityResultLauncher<String , Uri?> ,
    selectedUri: SnapshotStateList<Uri>
) {
    val stroke = Stroke(width = 2f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .defaultMinSize()
                .drawBehind {
                    drawRoundRect(color = Color.Gray , style = stroke)
                },
            contentAlignment = Alignment.Center,
            ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.cloud_upload_24) ,
                    contentDescription = "upload",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center)
                Text(
                    text = "JPEG, PNG & PDF formats, up to 5 MB", modifier = Modifier
                        .padding(bottom = 3.dp)
                        .defaultMinSize(), color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
        OutlinedButton( modifier = Modifier,onClick = {
            launcher1.launch("*/*")
        },
           ) {
            Text(text = "Browse files" ) } } }
        Spacer(modifier = Modifier.padding(top = 5.dp))
        UploadedListsDocuments(selectedUri)
        Spacer(modifier = Modifier.padding(top = 5.dp))
    }
}

@Composable
fun GetFiledtetails(onNavigateToHome: NavHostController) {
    val context = LocalContext.current


// Start file picker
//    getContent.launch("*/*")

}

@Composable
fun Documents(uri: Uri) {
    val context= LocalContext.current
//    val file:File = FileUtils.uriToFile(context,uri)
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(Color(0xFFB0B4BF))) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = rememberImagePainter(data = uri) , contentDescription = "image",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .size(75.dp))
            Text(text = "FileName.txt",
                style = MaterialTheme.typography.titleMedium)
            Icon(modifier = Modifier
                .fillMaxHeight()
                .size(40.dp),
                imageVector = Icons.Filled.Close , contentDescription ="close", tint = Color.Red )
        }

    }
}


@Composable
fun UploadedListsDocuments(selectedUri: SnapshotStateList<Uri>) {
LazyRow( ){
    items(selectedUri) {
        Documents(it)
    }
}
}


