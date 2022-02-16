package com.geeksforgeeks.jcpassonclicktofunction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent(){
    Scaffold(
        topBar = {TopAppBar(
            title = {Text(
                "GFG | Change Button Size",
                color = Color.White)},
            backgroundColor = Color(0xff0f9d58)
        ) },
        content = { MyContent()}
    )
}

@Composable
fun MyContent() {

    val mCounter = remember { mutableStateOf(0)}

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = mCounter.value.toString(), fontSize = 50.sp)

        Spacer(modifier = Modifier.height(50.dp))

        CreateButton(text = "Add 5") {
            mCounter.value += 5
        }

        Spacer(modifier = Modifier.height(50.dp))

        CreateButton(text = "Add 10") {
            mCounter.value += 10
        }

        Spacer(modifier = Modifier.height(50.dp))

        CreateButton(text = "Subtract 5") {
            mCounter.value -= 5
        }
    }
}

@Composable
fun CreateButton(text:String, onClick: ()-> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
    ){
        Text(text = text, color = Color.White)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}