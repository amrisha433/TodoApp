package com.example.todoapp.ui.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.RoomDatabase.TaskItem
import com.example.todoapp.ui.theme.CardWhite
import com.example.todoapp.ui.theme.CompletedCard
import com.example.todoapp.ui.theme.DarkText
import com.example.todoapp.ui.theme.DeleteRed
import com.example.todoapp.ui.theme.LightRedBorder
import com.example.todoapp.ui.theme.PremiumRed
import com.example.todoapp.ui.theme.SecondaryText
import com.example.todoapp.ui.theme.darkGray

//@Preview(showBackground = true,showSystemUi = true)


@Composable
fun ToDoItem(
    item: TaskItem,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (item.isDone)
                CompletedCard
            else
                CardWhite
        ),
        border = BorderStroke(
            1.dp,
            if (item.isDone)
                Color(0xFFE0E0E0)
            else
                LightRedBorder
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {

            IconButton(
                onClick = { onCheckedChange(!item.isDone) },
                modifier = Modifier.size(28.dp)
            ) {

                Icon(
                    imageVector = if (item.isDone)
                        Icons.Default.CheckCircle
                    else
                        Icons.Default.RadioButtonUnchecked,

                    contentDescription = "Task Status",

                    tint = if (item.isDone)
                        Color(0xFF2E7D32)
                    else
                        Color.Gray,

                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = item.taskName,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,

                modifier = Modifier.weight(1f),

                color = if (item.isDone)
                    SecondaryText
                else
                    DarkText,

                textDecoration = if (item.isDone)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )

            IconButton(
                onClick = onEditClick
            ) {

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Task",
                    tint = PremiumRed,
                    modifier = Modifier.size(22.dp)
                )
            }

            IconButton(
                onClick = onDeleteClick
            ) {

                Icon(
                    imageVector = Icons.Default.DeleteOutline,
                    contentDescription = "Delete Task",
                    tint = DeleteRed,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}