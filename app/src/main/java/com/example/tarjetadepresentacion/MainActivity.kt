/***
INTEGRANTES DEL GRUPO
-Sergio Ania Lázaro
-Ricardo De Antonio Aguirre
-Irene López Melero
 */

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
                    // Creamos la tarjeta de presentación
                    TarjetaDePresentacion()
                }
            }
        }
    }
}

/***
 * FUNCIÓN PARA CREAR LA TARJETA DE PRESENTACIÓN
 */
@Composable
fun TarjetaDePresentacion() {
        // Información de la tarjeta
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .padding(top = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingImage(
                    imageResource = R.drawable.ic_launcher_foreground,
                    descriptionResource = R.string.descripcion_logo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(225.dp)
                        .fillMaxWidth()
                        .background(colorResource(R.color.my_blue_light), CircleShape)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingText(
                    textResource = R.string.Nombre,
                    fontSize = 50,
                    colorStyle = colorResource(R.color.my_blue_dark)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                horizontalArrangement = Arrangement.Center
            ){
                GreetingText(
                    textResource = R.string.Ocupacion
                )
            }

            Line()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GreetingImage(
                    imageResource = R.drawable.telefono,
                    descriptionResource = R.string.descripcion_icon_telefono,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(21.dp)
                )
                GreetingText(
                    textResource = R.string.Telefono,
                    modifier = Modifier.width(210.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GreetingImage(
                    imageResource = R.drawable.correo,
                    descriptionResource = R.string.descripcion_icon_correo,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(21.dp)
                        .padding(1.dp)
                )
                GreetingText(
                    textResource = R.string.Correo,
                    modifier = Modifier.width(210.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                GreetingImage(
                    imageResource = R.drawable.ubicacion,
                    descriptionResource = R.string.descripcion_icono_ubicacion,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(21.dp)
                )
                GreetingText(
                    textResource = R.string.Residencia,
                    modifier = Modifier.width(210.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GreetingImage(
                    imageResource = R.drawable.firma,
                    descriptionResource = R.string.descripcion_firma,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    }

/***
FUNCIÓN PARA DIBUJAR UNA LINEA HORIZONTAL
 */
@Composable
fun Line() {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(1.dp)
            .background(colorResource(R.color.my_blue_light))
    )
}

/***
FUNCIÓN PARA ESCRIBIR LOS COMPONENTES DE TIPO TEXTO
 textResource: Int -> representa el recurso String empleado
 modifier: Modifier -> representa el modifier empleado para el texto
 fontSize: Int -> representa el tamaño de la fuente del texto
 colorStyle: Color -> representa el color de la fuente del texto
 */
@Composable
fun GreetingText(
    textResource: Int,
    modifier: Modifier = Modifier,
    fontSize: Int = 16,
    colorStyle: Color = colorResource(R.color.black)
) {
    Text(
        text = stringResource(textResource),
        fontSize = fontSize.sp,
        style = TextStyle(
            color = colorStyle
        ),
        modifier = modifier
    )
}

/***
FUNCIÓN PARA ESCRIBIR LOS COMPONENTES DE TIPO IMAGEN
 imageResource: Int -> representa el recurso Image empleado
 descriptionResource: Int -> representa el recurso String empleado para la descripción
 contentScale: ContentScale -> representa la escala empleada para la imagen
 modifier: Modifier -> representa el modifier empleado para la imagen
 */
@Composable
fun GreetingImage(
    imageResource: Int,
    descriptionResource: Int,
    contentScale: ContentScale,
    modifier: Modifier
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(descriptionResource),
        contentScale = contentScale,
        modifier = modifier
    )
}

/***
 * FUNCIÓN PARA PREVISUALIZAR LA TARJETA DE PRESENTACIÓN
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaDePresentacionTheme {
        TarjetaDePresentacion()
    }
}