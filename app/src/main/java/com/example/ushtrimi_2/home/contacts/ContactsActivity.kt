package com.example.ushtrimi_2.home.contacts

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ushtrimi_2.R
import com.example.ushtrimi_2.home.contacts.ui.theme.Ushtrimi_2Theme
import practice_1.Circle

class ContactsActivity : ComponentActivity() {


    private val TAG  = ContactsActivity::class.simpleName
    private val repo : ContactsRepo = ContactsRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ushtrimi_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContactsList(
                        contacts = repo.getContacts(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(contacts: List<ContactsUiModel>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        stickyHeader {
            Text(
                text = "Contacts",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(androidx.compose.material3.MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                color = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
            )
        }
        items(
            items = contacts,
            key = { it.id }
        ) { contact ->
            ContactRow(contact = contact)
            HorizontalDivider(thickness = 0.5.dp)
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun ContactRow(contact: ContactsUiModel, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(contact.avatarId),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = contact.firstName + "" + contact.lastName)
            Text(text = contact.email)
        }

        Image(
            painter = painterResource(R.drawable.ic_arrow_right),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
    }
}
