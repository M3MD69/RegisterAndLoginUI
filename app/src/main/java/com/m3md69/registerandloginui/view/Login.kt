package com.m3md69.registerandloginui.view

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.m3md69.registerandloginui.R

@Composable
fun LoginPage(navController: NavController) {
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf<String?>(null) }
    val password = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf<String?>(null) }
    val passwordVisibility = remember { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp),
                painter = painterResource(id = R.drawable.tablet_login_cuate),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(R.string.sign_in),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .padding(2.5.dp)
                    .fillMaxWidth(0.75F),
                singleLine = true,
                value = email.value,
                label = {
                    Text(
                        text = stringResource(R.string.email),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_email),
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                onValueChange = { email.value = it },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colorResource(id = R.color.lime_green),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = colorResource(id = R.color.lime_green),
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = colorResource(id = R.color.lime_green),
                    unfocusedLabelColor = Color.Black,
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.at),
                        contentDescription = null,
                        tint = colorResource(id = R.color.lime_green)
                    )
                }
            )
            emailError.value?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
            OutlinedTextField(
                modifier = Modifier
                    .padding(2.5.dp)
                    .fillMaxWidth(0.75F),
                singleLine = true,
                value = password.value,
                label = {
                    Text(
                        text = stringResource(R.string.password),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.enter_password),
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                onValueChange = { password.value = it },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = colorResource(id = R.color.lime_green),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = colorResource(id = R.color.lime_green),
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = colorResource(id = R.color.lime_green),
                    unfocusedLabelColor = Color.Black,
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.form_textbox_password),
                        contentDescription = null,
                        tint = colorResource(id = R.color.lime_green)
                    )
                },
                trailingIcon = {
                    val icon = if (passwordVisibility.value) painterResource(id = R.drawable.eye) else painterResource(id = R.drawable.eye_closed)
                    IconButton(
                        onClick = { passwordVisibility.value = !passwordVisibility.value },
                        content = {
                            Icon(
                                painter = icon,
                                contentDescription = null,
                                tint = if (passwordVisibility.value) colorResource(id = R.color.lime_green) else Color.Black
                            )
                        }
                    )
                },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
            )
            passwordError.value?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Button(
                modifier = Modifier.fillMaxWidth(0.75F),
                onClick = { validData(context = context, email = email, password = password, emailError = emailError, passwordError = passwordError) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.lime_green),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = stringResource(R.string.login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.padding(7.5.dp))
            Row {
                Text(text = stringResource(R.string.not_have_account), fontSize = 16.sp)
                Text(
                    modifier = Modifier.clickable(onClick = { navController.navigate(route = "RegisterPage") }),
                    text = stringResource(R.string.register),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

private fun validData(
    context: Context,
    email: MutableState<String>,
    password: MutableState<String>,
    emailError: MutableState<String?>,
    passwordError: MutableState<String?>,
) {
    val validEmail: Boolean
    val validPassword: Boolean

    if (email.value.isEmpty()) {
        validEmail = false
        emailError.value = context.getString(R.string.enter_email)
    } else if (!Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
        validEmail = false
        emailError.value = context.getString(R.string.enter_valid_email)
    } else {
        validEmail = true
        emailError.value = null
    }

    if (password.value.isEmpty()) {
        validPassword = false
        passwordError.value = context.getString(R.string.enter_password)
    } else if (password.value.length < 8) {
        validPassword = false
        passwordError.value = context.getString(R.string.short_password_minimum_8_characters)
    } else {
        validPassword = true
        passwordError.value = null
    }

    if (validEmail && validPassword) Toast.makeText(context, context.getString(R.string.done_login), Toast.LENGTH_SHORT).show()
}