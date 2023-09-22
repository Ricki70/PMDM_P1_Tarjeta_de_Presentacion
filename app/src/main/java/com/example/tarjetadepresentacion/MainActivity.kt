package com.example.tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TarjetaDePresentacion()
                }
            }
        }
    }
}

@Composable
fun TarjetaDePresentacion() {
        // Información de la tarjeta
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .padding(top = 50.dp)
                .fillMaxSize(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
            ) {
                GreetingImage(
                    R.drawable.ic_launcher_foreground,
                    R.string.descripcion_logo,
                    ContentScale.Crop,
                    Modifier
                        .size(225.dp)
                        .fillMaxWidth()
                        .background(Color(82, 199, 184), CircleShape)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingText(
                    R.string.Nombre,
                    50,
                    Color(0, 103, 91)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalArrangement = Arrangement.Center
            ){
                GreetingText(
                    R.string.Ocupacion,
                    16,
                    Color(0, 0, 0)
                )
            }

            Line()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingText(
                    R.string.Telefono,
                    16,
                    Color(0, 0, 0)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingText(R.string.Correo, 16, Color(0, 0, 0))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingText(
                    R.string.Residencia,
                    16,
                    Color(0, 0, 0)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
            ) {
                GreetingImage(
                    R.drawable.firma,
                    R.string.descripcion_firma,
                    ContentScale.Fit,
                    Modifier.size(200.dp)
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.Center
            ){
                GreetingText(
                    R.string.Web,
                    20,
                    Color(0, 103, 91)
                )
            }
        }
    }

/*
FUNCIÓN PARA DIBUJAR UNA LINEA HORIZONTAL
 */
@Composable
fun Line() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color(0, 103, 91))
    )
}

/*
FUNCIÓN PARA ESCRIBIR LOS COMPONENTES DE TIPO TEXTO
PARAMETERS.
 textResource: Int -> representa el recurso String empleado
 fontSize: Int -> representa el tamaño de la fuente del texto
 colorStyle: Color -> representa el color de la fuente del texto
 */
@Composable
fun GreetingText(textResource: Int, fontSize: Int, colorStyle: Color) {
    Text(
        text = stringResource(textResource),
        fontSize = fontSize.sp,
        style = TextStyle(
            color = colorStyle
        )
    )
}

/*
FUNCIÓN PARA ESCRIBIR LOS COMPONENTES DE TIPO IMAGEN
PARAMETERS.
 imageResource: Int -> representa el recurso Image empleado
 descriptionResource: Int -> representa el recurso String empleado para la descripción
 contentScale: ContentScale -> representa la escala empleada para la imagen
 modifier: Modifier -> representa el modifier empleado para la imagen
 */
@Composable
fun GreetingImage(imageResource: Int, descriptionResource: Int, contentScale: ContentScale, modifier: Modifier) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(descriptionResource),
        contentScale = contentScale,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        TarjetaDePresentacion()
    }
}