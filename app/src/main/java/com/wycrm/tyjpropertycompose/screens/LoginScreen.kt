package com.wycrm.tyjpropertycompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.wycrm.tyjpropertycompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToMain: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {


    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var phoneNumber by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = phoneNumber,
                singleLine = true,
                onValueChange = { if (it.length <= 11) phoneNumber = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = { Text(text = stringResource(id = R.string.phone_number)) }
            )
            var password by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = password,
                singleLine = true,
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = stringResource(id = R.string.password)) }
            )

            Button(
                onClick = {
                    viewModel.login()
//                    onNavigateToMain()
                }
            ) {
                Text(text = stringResource(id = R.string.login))
            }
        }

    }
}