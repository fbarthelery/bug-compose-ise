package com.geekorum.bugs.composelayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.geekorum.bugs.composelayout.ui.theme.BugComposeLayoutTheme

class FragmentB : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                BugComposeLayoutTheme {
                    Surface(Modifier.fillMaxSize()) {
                        Text("Fragment B", Modifier.wrapContentSize())
                    }
                }
            }
        }
    }
}
