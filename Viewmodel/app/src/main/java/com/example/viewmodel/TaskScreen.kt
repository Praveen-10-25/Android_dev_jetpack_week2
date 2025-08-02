import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viewmodel.TaskViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    val task by viewModel.task.observeAsState("")
    val tasklist by viewModel.tasklist.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            OutlinedTextField(
                value = task,
                onValueChange = {viewModel.onTaskChange(it) },
                modifier = Modifier.weight(1f),
                label = { Text("Enter Task") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { viewModel.addTask() }) {
                Text("Add")
            }
        }
        TaskList(
            taskList =tasklist,
            deleteTask = { task -> viewModel.deleteTask(task) }
        )
    }
}
