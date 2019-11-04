package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.reanimated.NodesManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class EventNode extends MapNode implements RCTEventEmitter {
  public EventNode(int nodeID, ReadableMap config, NodesManager nodesManager) {
    super(nodeID, config, nodesManager);
  }

  @Override
  public void receiveEvent(int targetTag, String eventName, @Nullable WritableMap event) {
    if (event == null) {
      throw new IllegalArgumentException("Animated events must have event data.");
    }

    setValue(event);
  }

  @Override
  public void receiveTouches(String eventName, WritableArray touches, WritableArray changedIndices) {
    throw new RuntimeException("receiveTouches is not support by animated events");
  }

}
