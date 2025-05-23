package com.example.deepwork.deep_work_app.presentation.components.toggle_switch_bar

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.deepwork.R
import com.example.deepwork.deep_work_app.data.util.parseTagColor
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Composable
fun TimerToggleBar(
    height: Dp,
    circleButtonPadding: Dp,
    circleBackgroundOnResource: String = "18402806360702976000",
    selectedState: Boolean,                       // ← Dışarıdan gelen seçili durum
    onCheckedChanged: (isOn: Boolean) -> Unit, // ← Dışarıdan tetiklenen callback
    toggleTimerUiState: Boolean
) {
//    var selectedState by remember { mutableStateOf(stateOn) }

    val buttonColor = parseTagColor(circleBackgroundOnResource)


    Row(
        modifier = Modifier
            .wrapContentSize() // İçeriğe göre genişlik ve yükseklik
            .height(height)
            .clip(RoundedCornerShape(height))
            .background(Color(0xFF1C1E22)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(
            visible = if (toggleTimerUiState && selectedState == true) false else true,
        ) {
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(height)
                    .padding(circleButtonPadding)
                    .clip(RoundedCornerShape(50))
                    .background(if (selectedState == false) buttonColor else Color(0xFF1C1E22))
                    .clickable {
                        onCheckedChanged(true)
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        Icons.Filled.AvTimer,
                        contentDescription = stringResource(R.string.timer_icon_description),
                        tint = Color.White
                    )
                    Text("Timer", color = Color.White)
                }
            }
        }

        AnimatedVisibility(
            visible =  if (toggleTimerUiState && selectedState == false) false else true,
        ){
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(height)
                    .padding(circleButtonPadding)
                    .clip(RoundedCornerShape(50))
                    .background(if (selectedState == true) buttonColor else Color(0xFF1C1E22)) // Seçili duruma göre renk
                    .clickable {
                        onCheckedChanged(false)
                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        Icons.Outlined.Timer,
                        contentDescription = stringResource(R.string.timer_icon_description),
                        tint = Color.White
                    )
                    Text("Stopwatch", color = Color.White)
                }
            }
        }

    }
}


@Preview
@Composable
fun TimerToggleBarPreview() {


}