package com.geekorum.bugs.composelayout

import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.geekorum.bugs.composelayout.ui.theme.BugComposeLayoutTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, FragmentA())
            }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BugComposeLayoutTheme {
        Greeting("Android")
    }
}
