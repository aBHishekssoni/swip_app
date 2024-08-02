package com.example.swipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.swipapp.ui.theme.SwipAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwipAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   pageScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun loginpage(modifier: Modifier = Modifier) {

//    var log by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Login by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center) {
        AnimatedVisibility(visible = !Login) {
            ExtendedFloatingActionButton(onClick = {Login = true} ) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                Spacer(modifier = Modifier.padding(6.dp))
                Text(text = "Login")
            }

        }
        AnimatedVisibility(visible = Login) {
            Card (
                modifier=Modifier.padding(16.dp)
            ){
                IconButton(onClick = { Login=false }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null,
                        modifier= Modifier
//                            .align(AbsoluteAlignment.CenterLeft)
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){

                    TextField(value = username, onValueChange = { username = it },
                        label = { Text("Username") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        }
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )

                        },
                        visualTransformation = PasswordVisualTransformation()
                    )
                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Sign in")
                    }
                }
            }
        }

    }
}


@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cpassword by remember { mutableStateOf("") }
    var isFormVisible by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {

        AnimatedVisibility(visible = !isFormVisible) {
            ExtendedFloatingActionButton(onClick = {
                isFormVisible = true
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Create new account")
            }
        }
        AnimatedVisibility(visible = isFormVisible) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextField(value = username, onValueChange = { username = it },
                        label = { Text("Username") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        }
                    )
                    TextField(
                        value = email, onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    TextField(
                        value = cpassword, onValueChange = { cpassword = it },
                        label = { Text("Confirm Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Sign Up")
                    }
                    IconButton(onClick = { isFormVisible = false }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun pageScreen(modifier: Modifier = Modifier) {
    val pagerstate=rememberPagerState(initialPage = 0, pageCount = {3})
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = (Alignment.Center)) {
        HorizontalPager(state = pagerstate, modifier = Modifier.fillMaxSize()) {

                when (it) {
                    0 -> loginpage()
                    1 -> SignUpScreen()
                    2 -> loginpage()
//                    else -> SignUpScreen()
                }

        }
    }
}

@Preview
@Composable
private fun pageScreenPriview() {
    pageScreen()
}
//
//@Preview
//@Composable
//private fun SignUpPreview() {
//    SignUpScreen()
//}
//@Preview(showBackground = true)
//@Composable
//private fun loginpagePreview() {
//    loginpage()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SwipAppTheme {
//        Greeting("Android")
//    }
//}