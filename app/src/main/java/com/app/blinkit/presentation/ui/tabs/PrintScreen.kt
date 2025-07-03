import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.blinkit.R
import com.app.blinkit.presentation.components.AssetImageView

@Composable
fun PrintScreen(){
    Box(modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.bg_beige))) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(54.dp));
            Text(text = "Print Store", fontWeight = FontWeight.Bold, fontSize = 26.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(text = "Blinkit ensures secure prints at every stage", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = colorResource(R.color.text_grey))

            Spacer(modifier = Modifier.height(54.dp));
            // print card
            Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), colors = CardDefaults.cardColors().copy(
                containerColor = MaterialTheme.colorScheme.tertiary
            )) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    // Text
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "Documents", fontWeight = FontWeight.Bold, fontSize = 20.sp);
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "✦  Price starting at rs 3/page", fontSize = 16.sp, color = colorResource(R.color.text_grey))
                        Text(text = "✦  Paper quality: 70 GSM", fontSize = 16.sp, color = colorResource(R.color.text_grey))
                        Text(text = "✦  Single side prints", fontSize = 16.sp, color = colorResource(R.color.text_grey))
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(onClick = {}, shape = RoundedCornerShape(8.dp), contentPadding = PaddingValues(vertical = 10.dp, horizontal = 24.dp),
                            colors = ButtonDefaults.buttonColors().copy(
                                containerColor = MaterialTheme.colorScheme.secondary
                            ) ) {
                            Text(text = "Upload Files", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        }
                    }

                    // Image
                    AssetImageView(imagePath = stringResource(R.string.doc_stack), modifier = Modifier.size(90.dp))
                }
            }
        }
    }
}