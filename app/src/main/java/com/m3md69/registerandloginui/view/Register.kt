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
fun RegisterPage(navController: NavController) {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val nameError = remember { mutableStateOf<String?>(null) }
    val phone = remember { mutableStateOf("") }
    val phoneError = remember { mutableStateOf<String?>(null) }
    val email = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf<String?>(null) }
    val password = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf<String?>(null) }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPassword = remember { mutableStateOf("") }
    val confirmPasswordError = remember { mutableStateOf<String?>(null) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

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
                painter = painterResource(id = R.drawable.sign_up_amico),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(R.string.sign_up),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .padding(2.5.dp)
                    .fillMaxWidth(0.75F),
                singleLine = true,
                value = name.value,
                label = {
                    Text(
                        text = stringResource(R.string.name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.enter_name),
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = { name.value = it },
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
                        painter = painterResource(id = R.drawable.form_textbox),
                        contentDescription = null,
                        tint = colorResource(id = R.color.lime_green)
                    )
                }
            )
            nameError.value?.let { error ->
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
                value = phone.value,
                label = {
                    Text(
                        text = stringResource(R.string.phone),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.enter_phone),
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                onValueChange = { phone.value = it.filter { it2 -> it2.isDigit() } },
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = null,
                            tint = colorResource(id = R.color.lime_green)
                        )
                        Text(
                            text = "+",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            )
            phoneError.value?.let { error ->
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
                    imeAction = ImeAction.Next
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
            OutlinedTextField(
                modifier = Modifier
                    .padding(2.5.dp)
                    .fillMaxWidth(0.75F),
                singleLine = true,
                value = confirmPassword.value,
                label = {
                    Text(
                        text = stringResource(R.string.confirm_password),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(R.string.enter_confirm_password),
                        color = Color.Gray
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                onValueChange = { confirmPassword.value = it },
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
                    val icon = if (confirmPasswordVisibility.value) painterResource(id = R.drawable.eye) else painterResource(id = R.drawable.eye_closed)
                    IconButton(
                        onClick = { confirmPasswordVisibility.value = !confirmPasswordVisibility.value },
                        content = {
                            Icon(
                                painter = icon,
                                contentDescription = null,
                                tint = if (confirmPasswordVisibility.value) colorResource(id = R.color.lime_green) else Color.Black
                            )
                        }
                    )
                },
                visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
            )
            confirmPasswordError.value?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

            }
            Spacer(modifier = Modifier.padding(15.dp))
            Button(
                modifier = Modifier.fillMaxWidth(0.75F),
                onClick = {
                    validData(
                        context = context,
                        name = name,
                        nameError = nameError,
                        phone = phone,
                        phoneError = phoneError,
                        email = email,
                        emailError = emailError,
                        password = password,
                        passwordError = passwordError,
                        confirmPassword = confirmPassword,
                        confirmPasswordError = confirmPasswordError
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.lime_green),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = stringResource(R.string.register),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.padding(7.5.dp))
            Row {
                Text(
                    text = stringResource(R.string.already_have_account),
                    fontSize = 16.sp
                )
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
    name: MutableState<String>,
    nameError: MutableState<String?>,
    phone: MutableState<String>,
    phoneError: MutableState<String?>,
    email: MutableState<String>,
    emailError: MutableState<String?>,
    password: MutableState<String>,
    passwordError: MutableState<String?>,
    confirmPassword: MutableState<String>,
    confirmPasswordError: MutableState<String?>,
) {
    val validName: Boolean
    val validPhone: Boolean
    val validEmail: Boolean
    val validPassword: Boolean
    val validConfirmPassword: Boolean

    if (name.value.isEmpty()) {
        validName = false
        nameError.value = context.getString(R.string.enter_name)
    } else {
        validName = true
        nameError.value = null
    }

    if (phone.value.isEmpty()) {
        validPhone = false
        phoneError.value = context.getString(R.string.enter_phone)
    } else {
        validPhone = true
        phoneError.value = null
    }

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

    if (confirmPassword.value.isEmpty()) {
        validConfirmPassword = false
        confirmPasswordError.value = context.getString(R.string.enter_confirm_password)
    } else if (confirmPassword === password) {
        validConfirmPassword = false
        confirmPasswordError.value = context.getString(R.string.confirm_password_not_equal_password)
    } else {
        validConfirmPassword = true
        confirmPasswordError.value = null
    }

    if (
        validName &&
        validPhone &&
        validEmail &&
        validPassword &&
        validConfirmPassword
    ) Toast.makeText(context, context.getString(R.string.done_register), Toast.LENGTH_SHORT).show()
}