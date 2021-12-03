package com.geekorum.bugs.composelayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.geekorum.bugs.composelayout.ui.theme.BugComposeLayoutTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

class FragmentA : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                BugComposeLayoutTheme {
                    ProvideWindowInsets {
                        DestinationA(onClick = {
                            navToB()
                        })
                    }
                }
            }
        }
    }

    private fun navToB() {
        parentFragmentManager.commit {
            replace(R.id.nav_host_fragment, FragmentB())
            addToBackStack("backstack")
        }
    }

}

@Composable
private fun DestinationA(onClick: ()->Unit) {
    Scaffold(topBar = {
            Surface(color = MaterialTheme.colors.primaryVariant) {
                TopAppBar(title = { Text("title") },
                    Modifier.statusBarsPadding()
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(visible = true) {
                BottomAppBar(modifier = Modifier.navigationBarsPadding()) {
                    Text("bottom app bar")
                }
            }
        }
    ) {
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Fragment A")
            Button(onClick = onClick) {
                Text("Next")
            }
        }
    }
}

