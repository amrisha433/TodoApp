package com.example.todoapp.ui.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.data.RoomDatabase.TaskItem
import com.example.todoapp.ui.theme.DarkRed
import com.example.todoapp.ui.theme.darkGray

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskEditorDialog(
    task: TaskItem?,
    onCancel: () -> Unit,
    onSave: (String) -> Unit
) {

    var taskName by remember { mutableStateOf(task?.taskName ?: "") }

    ModalBottomSheet(
        onDismissRequest = onCancel,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .navigationBarsPadding()
        ) {
            Text(text = if(task == null ) "Create New Task" else "Update Task",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Enter task details",
                color = Color(0xFF24292F)
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = taskName,
                onValueChange = { taskName = it },
                placeholder = { Text(text = "What needs to be done?") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = darkGray,
                    unfocusedBorderColor = Color.Gray
                ),
                shape = RoundedCornerShape(16.dp)

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onSave(taskName.trim()) },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkRed,
                ),
                enabled = taskName.isNotBlank()
            ){
                Text(text = "Save Task",
                    fontSize = 16.sp)

            }
        }

    }











}
