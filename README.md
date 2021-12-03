Compose-1.1.0-beta04 IllegalStateException
============

Sample project for [compose bug](https://issuetracker.google.com/issues/208855077)

Description
----------
In certain conditions an IllegalStateException occurs when popping a fragment transaction in compose-1.1.0-beta04.


How to reproduce?
-----------------
Launch the application, click on Next button, press Back button. The application will crash with the following stacktrace.

Expected result: go back to starting screen. It works on 1.1.0-beta03


Stacktrace
------------

```
2021-12-03 16:50:49.584 12614-12614/com.geekorum.bugs.composelayout D/AndroidRuntime: Shutting down VM
2021-12-03 16:50:49.586 12614-12614/com.geekorum.bugs.composelayout E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.geekorum.bugs.composelayout, PID: 12614
    java.lang.IllegalStateException: Place was called on a node which was placed already
        at androidx.compose.ui.node.LayoutNode.onNodePlaced$ui_release(LayoutNode.kt:941)
        at androidx.compose.ui.node.InnerPlaceable.placeAt-f8xVGno(InnerPlaceable.kt:125)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50(Placeable.kt:370)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50$default(Placeable.kt:203)
        at androidx.compose.ui.node.DelegatingLayoutNodeWrapper$measure$1$1.placeChildren(DelegatingLayoutNodeWrapper.kt:138)
        at androidx.compose.ui.node.DelegatingLayoutNodeWrapper.placeAt-f8xVGno(DelegatingLayoutNodeWrapper.kt:126)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50(Placeable.kt:370)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50$default(Placeable.kt:203)
        at androidx.compose.ui.node.DelegatingLayoutNodeWrapper$measure$1$1.placeChildren(DelegatingLayoutNodeWrapper.kt:138)
        at androidx.compose.ui.node.DelegatingLayoutNodeWrapper.placeAt-f8xVGno(DelegatingLayoutNodeWrapper.kt:126)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.placeWithLayer(Placeable.kt:393)
        at androidx.compose.ui.layout.Placeable$PlacementScope.placeWithLayer$default(Placeable.kt:266)
        at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1.invoke(GraphicsLayerModifier.kt:308)
        at androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1.invoke(GraphicsLayerModifier.kt:307)
        at androidx.compose.ui.layout.MeasureScope$layout$1.placeChildren(MeasureScope.kt:68)
        at androidx.compose.ui.node.DelegatingLayoutNodeWrapper.placeAt-f8xVGno(DelegatingLayoutNodeWrapper.kt:126)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50(Placeable.kt:370)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.placeOuterWrapper-f8xVGno(OuterMeasurablePlaceable.kt:171)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.access$placeOuterWrapper-f8xVGno(OuterMeasurablePlaceable.kt:28)
        at androidx.compose.ui.node.OuterMeasurablePlaceable$placeAt$1.invoke(OuterMeasurablePlaceable.kt:159)
        at androidx.compose.ui.node.OuterMeasurablePlaceable$placeAt$1.invoke(OuterMeasurablePlaceable.kt:158)
        at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:126)
        at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:88)
        at androidx.compose.ui.node.OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(OwnerSnapshotObserver.kt:69)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.placeAt-f8xVGno(OuterMeasurablePlaceable.kt:158)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place(Placeable.kt:367)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place$default(Placeable.kt:191)
        at androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1.invoke(Scaffold.kt:325)
        at androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1.invoke(Scaffold.kt:241)
        at androidx.compose.ui.layout.MeasureScope$layout$1.placeChildren(MeasureScope.kt:68)
        at androidx.compose.ui.layout.SubcomposeLayoutState$createMeasurePolicy$1$measure$1.placeChildren(SubcomposeLayout.kt:367)
        at androidx.compose.ui.node.LayoutNode$layoutChildren$1.invoke(LayoutNode.kt:978)
        at androidx.compose.ui.node.LayoutNode$layoutChildren$1.invoke(LayoutNode.kt:968)
        at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:126)
2021-12-03 16:50:49.587 12614-12614/com.geekorum.bugs.composelayout E/AndroidRuntime:     at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:88)
        at androidx.compose.ui.node.OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release(OwnerSnapshotObserver.kt:62)
        at androidx.compose.ui.node.LayoutNode.layoutChildren$ui_release(LayoutNode.kt:968)
        at androidx.compose.ui.node.LayoutNode.onNodePlaced$ui_release(LayoutNode.kt:954)
        at androidx.compose.ui.node.InnerPlaceable.placeAt-f8xVGno(InnerPlaceable.kt:125)
        at androidx.compose.ui.layout.Placeable.access$placeAt-f8xVGno(Placeable.kt:31)
        at androidx.compose.ui.layout.Placeable$PlacementScope.place-70tqf50(Placeable.kt:370)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.placeOuterWrapper-f8xVGno(OuterMeasurablePlaceable.kt:171)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.access$placeOuterWrapper-f8xVGno(OuterMeasurablePlaceable.kt:28)
        at androidx.compose.ui.node.OuterMeasurablePlaceable$placeAt$1.invoke(OuterMeasurablePlaceable.kt:159)
        at androidx.compose.ui.node.OuterMeasurablePlaceable$placeAt$1.invoke(OuterMeasurablePlaceable.kt:158)
        at androidx.compose.runtime.snapshots.Snapshot$Companion.observe(Snapshot.kt:1798)
        at androidx.compose.runtime.snapshots.SnapshotStateObserver.observeReads(SnapshotStateObserver.kt:121)
        at androidx.compose.ui.node.OwnerSnapshotObserver.observeReads$ui_release(OwnerSnapshotObserver.kt:88)
        at androidx.compose.ui.node.OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(OwnerSnapshotObserver.kt:69)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.placeAt-f8xVGno(OuterMeasurablePlaceable.kt:158)
        at androidx.compose.ui.node.OuterMeasurablePlaceable.replace(OuterMeasurablePlaceable.kt:183)
        at androidx.compose.ui.node.LayoutNode.replace$ui_release(LayoutNode.kt:856)
        at androidx.compose.ui.node.MeasureAndLayoutDelegate.remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate.kt:238)
        at androidx.compose.ui.node.MeasureAndLayoutDelegate.access$remeasureAndRelayoutIfNeeded(MeasureAndLayoutDelegate.kt:38)
        at androidx.compose.ui.node.MeasureAndLayoutDelegate.measureAndLayout(MeasureAndLayoutDelegate.kt:205)
        at androidx.compose.ui.platform.AndroidComposeView.measureAndLayout(AndroidComposeView.android.kt:658)
        at androidx.compose.ui.node.Owner$DefaultImpls.measureAndLayout$default(Owner.kt:182)
        at androidx.compose.ui.platform.AndroidComposeView.dispatchDraw(AndroidComposeView.android.kt:842)
        at android.view.View.draw(View.java:22647)
        at android.view.View.updateDisplayListIfDirty(View.java:21519)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ViewGroup.recreateChildDisplayList(ViewGroup.java:4512)
        at android.view.ViewGroup.dispatchGetDisplayList(ViewGroup.java:4485)
        at android.view.View.updateDisplayListIfDirty(View.java:21475)
        at android.view.ThreadedRenderer.updateViewTreeDisplayList(ThreadedRenderer.java:534)
        at android.view.ThreadedRenderer.updateRootDisplayList(ThreadedRenderer.java:540)
        at android.view.ThreadedRenderer.draw(ThreadedRenderer.java:616)
2021-12-03 16:50:49.587 12614-12614/com.geekorum.bugs.composelayout E/AndroidRuntime:     at android.view.ViewRootImpl.draw(ViewRootImpl.java:4421)
        at android.view.ViewRootImpl.performDraw(ViewRootImpl.java:4149)
        at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:3309)
        at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:2126)
        at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:8653)
        at android.view.Choreographer$CallbackRecord.run(Choreographer.java:1037)
        at android.view.Choreographer.doCallbacks(Choreographer.java:845)
        at android.view.Choreographer.doFrame(Choreographer.java:780)
        at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:1022)
        at android.os.Handler.handleCallback(Handler.java:938)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loopOnce(Looper.java:201)
        at android.os.Looper.loop(Looper.java:288)
        at android.app.ActivityThread.main(ActivityThread.java:7839)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)

```
