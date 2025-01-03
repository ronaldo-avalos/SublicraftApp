package com.coopertech.sublicraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.coopertech.sublicraft.ui.theme.SublicraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SublicraftTheme {
                SubliCraftApp(
                    context = this,
                    modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//
//@Preview(showSystemUi = true)
//@Composable
//fun MainPreview() {
//    SublicraftTheme{
//        SubliCraftApp()
//    }
//}
//
//@Preview(showBackground = true, widthDp = 700, heightDp = 500)
//@Composable
//fun SubliCraftAppPreviewTablet() {
//    SublicraftTheme{
//        SubliCraftApp()
//    }
//}
//
//@Preview(showBackground = true, widthDp = 500, heightDp = 700)
//@Composable
//fun SubliCraftAppPreviewTabletPortrait() {
//    SublicraftTheme{
//        SubliCraftApp()
//    }
//}
//
//
//@Preview(showBackground = true, widthDp = 1100, heightDp = 600)
//@Composable
//fun SubliCraftAppPreviewDesktop() {
//    SublicraftTheme{
//        SubliCraftApp()
//    }
//}
//
//@Preview(showBackground = true, widthDp = 600, heightDp = 1100)
//@Composable
//fun SubliCraftAppPreviewDesktopPortrait() {
//    SublicraftTheme{
//        SubliCraftApp()
//    }
//}
