package com.wycrm.tyjpropertycompose.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.wycrm.tyjpropertycompose.R
import com.wycrm.tyjpropertycompose.ui.uistate.LoginUiState
import com.wycrm.tyjpropertycompose.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "LoginScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToMain: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState
    val context = LocalContext.current
    LaunchedEffect(key1 = uiState) {
        launch {
            uiState.collect {
                when (it) {
                    LoginUiState.Default -> Log.i(TAG, "LoginScreen: default")
                    is LoginUiState.Failure -> Toast.makeText(context, it.errorMessage, Toast.LENGTH_LONG).show()
                    LoginUiState.Loading -> Log.i(TAG, "LoginScreen: loading")
                    LoginUiState.Success -> onNavigateToMain()
                }
            }
        }
    }


    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = viewModel.account,
                singleLine = true,
                onValueChange = { if (it.length <= 11) viewModel.updateAccount(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = { Text(text = stringResource(id = R.string.phone_number)) }
            )

            OutlinedTextField(
                value = viewModel.password,
                singleLine = true,
                onValueChange = { viewModel.updatePassword(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = stringResource(id = R.string.password)) }
            )

            Button(
                onClick = {
                    viewModel.login()
                }
            ) {
                Text(text = stringResource(id = R.string.login))
            }
        }


    }
}